package com.jay.application.controller;


import java.util.List;
import java.util.Objects;

import com.jay.application.utils.*;
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

/**
 * @author jay
 */
@Controller
public class IndexController {

    @Autowired
    private ArticlesService articlesService;

    @NoToken
    @RequestMapping("/")
    public String index() {
        return "index.html";
    }

    /**
     * 按发布时间获取前六条
     *
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
     *
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
