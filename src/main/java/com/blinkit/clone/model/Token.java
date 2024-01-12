package com.blinkit.clone.model;

import jakarta.persistence.*;

@Entity
public class Token {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tokenId;
	private String token;
	@OneToOne
	private User user;
	
	
	public Token() {
		super();
	}


	public Token(String token, User user) {
		super();
		this.token = token;
		this.user = user;
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


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Token [tokenId=" + tokenId + ", token=" + token + ", userId=" + user + "]";
	}
	
	
	
}
