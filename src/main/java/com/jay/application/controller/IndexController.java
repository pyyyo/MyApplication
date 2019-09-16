package com.jay.application.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jay.application.annotation.NoToken;
import com.jay.application.annotation.YesToken;
import com.jay.application.pojo.Users;
import com.jay.application.services.UsersService;
import com.jay.application.utils.MD5Utils;
import com.jay.application.utils.RestResult;
import com.jay.application.utils.ResultGenerator;
import com.jay.application.utils.TokenUtils;

@Controller
public class IndexController {

	@Autowired
	private UsersService usersService;
	
	@NoToken
	@RequestMapping("/")
	public String index() {
		return "login.html";
	}
	
	@NoToken
	@ResponseBody
	@RequestMapping("login")
	public RestResult login(String userName,String passWord) {
		if(userName.isEmpty() || passWord.isEmpty()) {
			return new ResultGenerator().getSuccessResult("登录失败,用户名或密码不能为空", null);
		}
		
		Users users = usersService.loginByUserName(userName);
		if(users != null) {
			if(users.getUserPassword().equals(MD5Utils.calc(passWord))) {
				users.setToken(TokenUtils.getToken(users));
				return new ResultGenerator().getSuccessResult("登录成功", users);
			}else {
				return new ResultGenerator().getFailResult("登录失败,密码错误");
			}
		}else {
			return new ResultGenerator().getFailResult("登录失败,用户名不存在");
		}
	}
	
	@YesToken
	@ResponseBody
	@RequestMapping("getMessage")
	public RestResult getMessage() {
		return new ResultGenerator().getSuccessResult("yes", null);
	}
}
