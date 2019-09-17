package com.jay.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.application.dao.ArticlesDao;
import com.jay.application.pojo.Articles;

@Service
public class ArticlesService {
	
	@Autowired
	ArticlesDao articlesDao;
	
	public List<Articles> getArticlesAll(){
		return articlesDao.getArticlesAll();
	}
	
	public Articles getArticlesById(Integer articlId) {
		return articlesDao.getArticlesById(articlId);
	}
}
