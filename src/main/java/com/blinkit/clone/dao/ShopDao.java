package com.blinkit.clone.dao;

import com.blinkit.clone.model.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopDao extends JpaRepository<Shop,Integer> {
}
