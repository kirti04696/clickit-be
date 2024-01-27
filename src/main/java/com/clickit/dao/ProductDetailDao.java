package com.clickit.dao;

import com.clickit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDetailDao extends JpaRepository<Product,Integer> {
}
