package com.jay.application.controller;

import com.jay.application.annotation.NoToken;
import com.jay.application.pojo.Users;
import com.jay.application.services.UsersService;
import com.jay.application.utils.MD5Utils;
import com.jay.application.utils.RestResult;
import com.jay.application.utils.ResultGenerator;
import com.jay.application.utils.TokenUtils;
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
    public RestResult login(String userName, String passWord) {
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
