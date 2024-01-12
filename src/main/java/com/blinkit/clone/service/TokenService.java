package com.blinkit.clone.service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.clone.dao.TokenDao;
import com.blinkit.clone.dao.UserDao;
import com.blinkit.clone.model.Token;
import com.blinkit.clone.model.User;

@Service
public class TokenService {
	
	@Autowired
	TokenDao tokenDao;
	
	@Autowired
	UserService userService;

	public Token generateToken(User user) {
		 UUID uuid = UUID.randomUUID();
		 Token existingToken;
		 String uuidAsString;
	     do {
	    	 uuidAsString = uuid.toString();
	    	 existingToken = tokenDao.findByToken(uuidAsString);
	     }while(existingToken != null);
	     Token token = new Token();
		 token.setToken(uuidAsString);
		 token.setUser(user);
	     token = tokenDao.save(token);
		return token;
	}

	public void logout(String token) {
   	 Token existingToken = tokenDao.findByToken(token);
   	 if(existingToken != null) {
   		 tokenDao.delete(existingToken);
   	 }
		
	}

	public User getUserByToken(String token) throws Exception {
		Token existingToken = tokenDao.findByToken(token);
		if(existingToken == null) {
			throw new Exception("Not a valid token!");
		}

		return existingToken.getUser();
	}
}
