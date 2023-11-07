package com.blinkit.clone.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blinkit.clone.model.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
