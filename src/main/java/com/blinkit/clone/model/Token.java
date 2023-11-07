package com.blinkit.clone.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tokenId;
	private String token;
	private Long userId;
	
	
	public Token() {
		super();
	}


	public Token(String token, Long userId) {
		super();
		this.token = token;
		this.userId = userId;
	}


	public int getTokenId() {
		return tokenId;
	}


	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
	}


	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", token=" + token + ", userId=" + userId + "]";
	}
	
	
	
}
