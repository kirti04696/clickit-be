package com.blinkit.clone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.blinkit.clone.model.User;
import com.blinkit.clone.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;
	
	@CrossOrigin
	@PostMapping("/signUp")
	public String signUp(@RequestBody User user) {
		userService.signUp(user);
		return "Account created successfully";
	}
	
	@CrossOrigin
	@GetMapping("/login")
	public String login(@RequestBody User user) {
		user = userService.login(user);
		if(user == null)return "login faild";
		else {
			return "logging successful";
		}
	}
	
}
