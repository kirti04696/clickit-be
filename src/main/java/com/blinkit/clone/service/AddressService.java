package com.blinkit.clone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blinkit.clone.dao.AddressDao;
import com.blinkit.clone.model.Address;

@Service
public class AddressService {
	@Autowired
	AddressDao addressDao;
	
	public Address addAddress(Address address) {
		addressDao.save(address);
		return address;
		
	}

}
