package com.jay.application.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.application.dao.CommentsDao;

@Service
public class CommentsService {
	
	@Autowired
	CommentsDao commentsDao;
}
