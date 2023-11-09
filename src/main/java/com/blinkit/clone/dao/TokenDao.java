package com.blinkit.clone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.clone.model.Token;

public interface TokenDao extends JpaRepository<Token, Integer> {

	public Token findByToken(String uuidAsString);

}
