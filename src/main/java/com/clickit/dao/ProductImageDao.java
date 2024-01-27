package com.clickit.dao;

import com.clickit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductImageDao extends JpaRepository<Product,Integer> {
}
