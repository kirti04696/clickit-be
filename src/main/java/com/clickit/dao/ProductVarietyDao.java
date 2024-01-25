package com.clickit.dao;

import com.clickit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVarietyDao extends JpaRepository<Product,Integer> {
}
