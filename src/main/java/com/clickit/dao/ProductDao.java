package com.clickit.dao;

import com.clickit.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductDao extends JpaRepository<Product,Integer> {
    public List<Product> findByProductNameContaining(String productName);


}
