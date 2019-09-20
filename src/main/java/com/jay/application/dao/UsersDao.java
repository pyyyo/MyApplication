package com.jay.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jay.application.pojo.Users;

/**
 * 
 * @author jay
 *
 */
@Repository
@Mapper
public interface UsersDao {
	/**
	 * 获取所有用户
	 * @return
	 */
	List<Users> getAll();
	
	/**
	 * 根据用户名获取用户信息
	 * @param userName
	 * @return
	 */
	Users loginByUserName(@Param("userName") String userName);
	
	/**
	 * 根据用户id获取用户信息
	 * @param userId
	 * @return
	 */
	Users getUsersById(@Param("userId")Integer userId);
}
