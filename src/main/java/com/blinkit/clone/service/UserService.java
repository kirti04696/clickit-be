package com.blinkit.clone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.clone.dao.UserDao;
import com.blinkit.clone.model.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public void signUp(User user) {
		userDao.save(user);
		
	}

	public User login(User user) {
		user = userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return user;
	}

}
