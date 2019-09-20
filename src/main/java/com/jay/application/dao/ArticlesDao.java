package com.jay.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jay.application.pojo.Articles;

/**
 * 
 * @author jay
 *
 */
@Repository
@Mapper
public interface ArticlesDao {
	
	/**
	 * 获取所有博文，前六条
	 * @return
	 */
	List<Articles> getArticlesAll();

	/**
	 * 根据id获取博文信息
	 * @param articlId
	 * @return
	 */
	Articles getArticlesById(@Param("articlId")Integer articlId);
}
