package com.armaan.product_service.dao;

import com.armaan.product_service.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao extends JpaRepository<Product, String> {
    Product findByProductId(String productId);

    List<Product> findAllByCategory_CategoryId(Integer categoryId);
}
