package com.blinkit.clone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.clone.model.User;

public interface UserDao extends JpaRepository<User, Long> {

	public User findByEmailAndPassword(String email, String password);

	public User findByEmail(String email);

	
}
