package com.jay.application.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jay.application.pojo.Users;

@Repository
@Mapper
public interface UsersDao {
	List<Users> getAll();
	
	Users loginByUserName(@Param("userName") String userName);
	
	Users getUsersById(@Param("userId")Integer userId);
}
