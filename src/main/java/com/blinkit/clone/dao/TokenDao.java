package com.blinkit.clone.dao;

import com.blinkit.clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.clone.model.Token;

public interface TokenDao extends JpaRepository<Token, Integer> {

	public Token findByToken(String uuidAsString);

	public Token findByUser(User user);

}
