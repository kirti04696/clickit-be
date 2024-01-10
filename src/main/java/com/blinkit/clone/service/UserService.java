package com.blinkit.clone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.clone.dao.UserDao;
import com.blinkit.clone.model.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;
	
	public User signUp(User user) throws Exception {
		
		User available = userDao.findByEmail(user.getEmail());
		if(available!= null) {
			throw new Exception("Already registered email");
		}
		User created_user = userDao.save(user);
		return created_user;
	}

	public User login(User user)throws Exception {
		if(user.getEmail()==null) {
			throw new Exception("Email is required");
		}else if(user.getPassword()==null) {
			throw new Exception("password is required");
		}
		user = userDao.findByEmailAndPassword(user.getEmail(), user.getPassword());
		return user;
	}
	
	public User getUserById(Long id) {
		User user = userDao.getById(id);
		if(user != null) {
			return user;
		}
		return null;
	}

	public List<User> getAllUser() {
		List<User> users = userDao.findAll();

		return users;
	}

}
