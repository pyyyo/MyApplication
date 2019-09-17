package com.jay.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jay.application.pojo.Articles;

@Repository
@Mapper
public interface ArticlesDao {
	
	List<Articles> getArticlesAll();

	Articles getArticlesById(@Param("articlId")Integer articlId);
}
