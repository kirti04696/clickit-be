package com.blinkit.clone.controller;

import org.hibernate.mapping.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpServerErrorException;

import com.blinkit.clone.common.ErrorResponse;
import com.blinkit.clone.common.Response;
import com.blinkit.clone.model.Address;
import com.blinkit.clone.model.Token;
import com.blinkit.clone.model.User;
import com.blinkit.clone.service.TokenService;
import com.blinkit.clone.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserService userService;
	
	@Autowired
	TokenService tokenService;
	
	@CrossOrigin
	@PostMapping("/signup")
	public ResponseEntity<Object> signUp(@RequestBody User user) {
		Response response = new Response();
		try {
			if(user.getEmail() == "" || user.getEmail() == null) {
				response.setMessage("Email is required");
				response.setStatus(HttpStatus.BAD_REQUEST);
				return response.sendResponse();
			}
			else if(user.getPassword() == "" || user.getPassword() == null) {
				response.setMessage("Password is required");
				response.setStatus(HttpStatus.BAD_REQUEST);
				return response.sendResponse();
			}
			else if(user.getName() ==null || user.getName().equals("")) {
				response.setMessage("User name is required");
				response.setStatus(HttpStatus.BAD_REQUEST);
				return response.sendResponse();
			}
			user.setUserType("USER");
			user = userService.signUp(user);
			return new ResponseEntity<>(user, HttpStatus.OK);
		} catch (Exception e) {
			response.setMessage(e.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST);
			return response.sendResponse();
		}   
		
	}
	
	@CrossOrigin()
	@PostMapping("/login")
	public ResponseEntity<Object> login(@RequestBody User user) {
		Response response = new Response();
		User newUser = null;
		try {
			if(user.getEmail() == "" || user.getEmail() == null) {
				response.setMessage("Email is required");
				response.setStatus(HttpStatus.BAD_REQUEST);
				return response.sendResponse();
			}
			else if(user.getPassword() == "" || user.getPassword() == null) {
				response.setMessage("Password is required");
				response.setStatus(HttpStatus.BAD_REQUEST);
				return response.sendResponse();
			}
			 
			newUser = userService.login(user);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		if(newUser == null) {
			response.setMessage("login failed");
			response.setStatus(HttpStatus.BAD_REQUEST);
			return response.sendResponse();
		}
		else {
			Token token= tokenService.createToken(newUser.getUserId());
			response.setData(token);
			response.setMessage("Successfully login.");
			response.setStatus(HttpStatus.OK);
			return response.sendResponse();
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
		Response response = new Response();
		try {
			User user = tokenService.getUserByToken(token);
			response.setData(user);
			response.setMessage("User profile details fetched successfully.");
			response.setStatus(HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST);
		}
		return response.sendResponse();
//		return null;
		
	}
	
}
