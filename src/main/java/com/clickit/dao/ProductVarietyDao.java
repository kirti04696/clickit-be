package com.clickit.dao;

import com.clickit.model.Product;
import com.clickit.model.ProductVariety;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductVarietyDao extends JpaRepository<ProductVariety,Integer> {
}
