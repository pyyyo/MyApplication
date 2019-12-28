package com.jay.application.controller;

import com.jay.application.annotation.*;
import com.jay.application.pojo.Users;
import com.jay.application.services.UsersService;
import com.jay.application.utils.*;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author jay
 */
@Controller
public class LoginController {

    @Autowired
    private UsersService usersService;

    /**
     * 登录
     *
     * @param userName
     * @param passWord
     * @return
     */
    @NoToken
    @ResponseBody
    @RequestMapping("login")
    public RestResult login(String userName, String passWord, String key, String publicKey) throws Exception {
        System.out.println(userName);           //已用AES密钥加密的用户名
        System.out.println(passWord);           //已用AES密钥加密的密码
        System.out.println(key);                //用后端传给前端的RSA公钥加密的前端AES密钥
        System.out.println(publicKey);          //前端RSA公钥
        System.out.println(RsaUtil.getPublicKey());//后端RSA公钥
        byte[] clientAESKey = RsaUtil.decryptByPrivateKey(Base64.decodeBase64(key), RsaUtil.getPrivateKey());
        String clientAESKeyStr = new String(clientAESKey);
        System.out.println("解密出来的AES的key：" + clientAESKeyStr);

        clientAESKeyStr = clientAESKeyStr.substring(1, clientAESKeyStr.length() - 1);

        userName = AesUtil.decrypt(userName, clientAESKeyStr);
        passWord = AesUtil.decrypt(passWord, clientAESKeyStr);

        System.out.println("解密后的用户名：" + userName);
        System.out.println("解密后的密  码：" + passWord);

        if (userName.isEmpty() || passWord.isEmpty()) {
            return new ResultGenerator().getSuccessResult("登录失败,用户名或密码不能为空", null);
        }

        Users users = usersService.loginByUserName(userName);
        if (users != null) {
            if (users.getUserPassword().equals(MD5Utils.calc(passWord))) {
                users.setToken(TokenUtils.getToken(users));
                return new ResultGenerator().getSuccessResult("登录成功", users);
            } else {
                return new ResultGenerator().getFailResult("登录失败,密码错误");
            }
        } else {
            return new ResultGenerator().getFailResult("登录失败,用户名不存在");
        }
    }

    /**
     * return RSAPublicKey
     * 前端获取后端RSA公钥接口
     *
     * @return
     */
    @NoToken
    @ResponseBody
    @RequestMapping("getRSAKey")
    public RestResult getRSAKey() {
        return new ResultGenerator().getSuccessResult(RsaUtil.getPublicKey());
    }

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @NoToken
    @ResponseBody
    @RequestMapping("registered")
    public RestResult registered(Users user) {
        if (null != user) {
            if (!(user.getUserName().isEmpty() || user.getUserPassword().isEmpty() || user.getUserTelephoneNumber().isEmpty())) {
                user.setUserPassword(MD5Utils.calc(user.getUserPassword()));
                // 注册成功
                Integer temp = usersService.registeredUser(user);
                if (0 < temp) {
                    return new ResultGenerator().getSuccessResult();
                }
            }
        }
        return new ResultGenerator().getFailResult("注册失败");
    }

    /**
     * 查询用户名是否已被注册
     *
     * @param userName
     * @return
     */
    @NoToken
    @ResponseBody
    @RequestMapping("getUserByName")
    public RestResult getUserByName(String userName) {
        if (userName.isEmpty()) {
            return new ResultGenerator().getFailResult("用户名不能为空");
        }

        Users user = usersService.loginByUserName(userName);
        if (null != user) {
            return new ResultGenerator().getFailResult("用户名已存在");
        }
        return new ResultGenerator().getSuccessResult();
    }
}
