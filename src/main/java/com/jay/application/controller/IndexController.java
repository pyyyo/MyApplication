package com.jay.application.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jay.application.annotation.NoToken;
import com.jay.application.annotation.YesToken;
import com.jay.application.pojo.Articles;
import com.jay.application.pojo.Users;
import com.jay.application.services.ArticlesService;
import com.jay.application.services.UsersService;
import com.jay.application.utils.DateUtils;
import com.jay.application.utils.MD5Utils;
import com.jay.application.utils.RestResult;
import com.jay.application.utils.ResultGenerator;
import com.jay.application.utils.TokenUtils;

/**
 * 
 * @author jay
 *
 */
@Controller
public class IndexController {

	@Autowired
	private UsersService usersService;
	
	@Autowired
	private ArticlesService articlesService;
	
	@NoToken
	@RequestMapping("/")
	public String index() {
		return "index.html";
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
	
	/**
	 * 按发布时间获取前六条
	 * @return
	 */
	@NoToken
	@ResponseBody
	@RequestMapping("getAllArticles")
	public RestResult getAllArticles() {
		
		List<Articles> list = articlesService.getArticlesAll();
		for (Articles articles : list) {
			articles.setArticDateString(DateUtils.parseDateToString(articles.getArticDate()));
		}
		return new ResultGenerator().getSuccessResult(list);
	}
	
	
	/**
	 * 根据id查询博文
	 * @param id
	 * @return
	 */
	@NoToken
	@ResponseBody
	@RequestMapping("getArticlesById")
	public RestResult getArticlesById(String id) {
		Articles articles = articlesService.getArticlesById(Integer.valueOf(id));
		articles.setArticDateString(DateUtils.parseDateToString(articles.getArticDate()));
		return new ResultGenerator().getSuccessResult(articles);
	}
}
