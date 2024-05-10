package com.clickit.controller;

import com.clickit.common.Response;
import com.clickit.model.*;
import com.clickit.service.CartService;
import com.clickit.service.ShopService;
import com.clickit.service.TokenService;
import com.clickit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
    UserService userService;
	
	@Autowired
    TokenService tokenService;
	@Autowired
	CartService cartService;

	@Autowired
	ShopService shopService;
	
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
			Map<String, Object> data = new HashMap<>();
			Token token= tokenService.generateToken(newUser);
			data.put("tokenData", token);
			if(newUser.getUserType().equals("SHOP_OWNER")){
				Shop shop = shopService.getShopByShopOwner(newUser);
				data.put("shopData", shop);
			}
			response.setData(data);
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
	public ResponseEntity<Object> profile(@RequestAttribute("auth-user")User user){
		Response response = new Response();
		try {
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
	@PutMapping("/change-password")
	public ResponseEntity<Object>changePassword(@RequestHeader("token") String token,@RequestBody  User newuser)
	{
	   	
		Response response = new Response();
		//get the user data from token
	      
		try {
			User user=tokenService.getUserByToken(token);
			
			//step 1:previous password
			//step 2:
			if(user==null)
			{
				response.setMessage("Password not matched");
				response.setStatus(HttpStatus.OK);
			}
			else
			{
			user.setPassword(newuser.getPassword());
			userService.updateUser(user);
			response.setMessage("Your Password is succesfully changed");
			response.setStatus(HttpStatus.OK);
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST);
		}

		return response.sendResponse();
	}

	@PostMapping("/add-to-cart")
	public ResponseEntity<Object> addToCart(@RequestBody Cart cart){
		Response response = new Response();
		try {
			if (cart == null) {
				response.setMessage("");
				response.setStatus(HttpStatus.BAD_REQUEST);
				return response.sendResponse();
			}

			cart = cartService.addToCart(cart);
		}catch (Exception e){
			e.printStackTrace();
			response.setMessage(e.getMessage());
			response.setStatus(HttpStatus.BAD_REQUEST);
		}

		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

}

