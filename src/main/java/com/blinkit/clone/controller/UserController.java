package com.blinkit.clone.controller;

import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import com.blinkit.clone.common.ErrorResponse;
import com.blinkit.clone.model.Address;
import com.blinkit.clone.model.Token;
import com.blinkit.clone.model.User;
import com.blinkit.clone.service.TokenService;
import com.blinkit.clone.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	TokenService tokenService;
	
	@CrossOrigin
	@PostMapping("/signUp")
	public ResponseEntity<Object> signUp(@RequestBody User user) {
		try {
			user = userService.signUp(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
		}   
		
	}
	
	@CrossOrigin()
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user) {
		try {
			user = userService.login(user);
		} catch (Exception e) {

			e.printStackTrace();
		}
		if(user == null)return new ResponseEntity("login failed", HttpStatus.UNAUTHORIZED);
		else {
			Token token= tokenService.createToken(user.getUserId());
			
			return new ResponseEntity(token, HttpStatus.OK);
		}
	}
	
	
	public ResponseEntity<Object> addAddress(@RequestBody Address address) {
		
		return null;
	}
	
	@CrossOrigin
	@GetMapping("/logout")
	public ResponseEntity<Object> logout(@RequestHeader("token") String token){
		tokenService.logout(token);
		return new ResponseEntity<Object>("logout successfully",HttpStatus.OK);
	}
	
	@CrossOrigin
	@GetMapping("/my-profile")
	public ResponseEntity<Object> profile(@RequestHeader("token") String token){
		try {
			User user = tokenService.getUserByToken(token);
			return new ResponseEntity<>(user,HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ResponseEntity<Object>(new ErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
		}
//		return null;
		
	}
	
}
