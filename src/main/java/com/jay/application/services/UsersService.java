package com.jay.application.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.application.dao.UsersDao;
import com.jay.application.pojo.Users;

@Service
public class UsersService {
	
	@Autowired
	UsersDao usersDao;
	
	public List<Users> getAll() {
		return usersDao.getAll();
	}
	
	public Users loginByUserName(String userName) {
		return usersDao.loginByUserName(userName);
	}
	
	public Users getUsersById(Integer userId) {
		return usersDao.getUsersById(userId);
	}

	public Integer registeredUser(Users user){
		return usersDao.registeredUser(user);
	}
}
