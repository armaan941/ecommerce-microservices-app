package com.armaan.product_service.dao;

import com.armaan.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
    Product findByProductId(String productId);
}
