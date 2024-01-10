package com.blinkit.clone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.blinkit.clone.common.ErrorResponse;
import com.blinkit.clone.model.Address;
import com.blinkit.clone.model.User;
import com.blinkit.clone.service.AddressService;
import com.blinkit.clone.service.TokenService;

@RestController
@RequestMapping("/address")
public class AddressController {
	@Autowired
	AddressService addressService;
	
	@Autowired
	TokenService tokenService;
	
	
	
	@CrossOrigin
	@PostMapping("")
	public ResponseEntity<Object> addAddress(@RequestBody Address address,@RequestHeader String token){
		try {
			User user = tokenService.getUserByToken(token);
			if(user == null) {
				return new ResponseEntity<Object>(new ErrorResponse("User not found"),HttpStatus.BAD_REQUEST);
			}
			
			address.setUserId(user.getUserId().intValue());
			Address add = addressService.addAddress(address);
			return new ResponseEntity<Object>(add,HttpStatus.CREATED);
		} catch (Exception e) {
			
			e.printStackTrace();
			return new ResponseEntity<Object>(new ErrorResponse(e.getMessage()),HttpStatus.BAD_REQUEST);
			
		}
		
	}

}
