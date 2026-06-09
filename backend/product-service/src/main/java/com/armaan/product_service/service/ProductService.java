package com.armaan.product_service.service;

import com.armaan.product_service.dao.ProductDao;
import com.armaan.product_service.dto.ProductIdRequest;
import com.armaan.product_service.dto.ProductRequest;
import com.armaan.product_service.mapper.ProductMapper;
import com.armaan.product_service.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    ProductMapper productMapper;

    public ResponseEntity<List<Product>> getAllProducts() {
        try {
            return new ResponseEntity<>(productDao.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<Product> addProduct(ProductRequest productRequest) {
        Product product = productMapper.toEntity(productRequest);
        return new ResponseEntity<>(productDao.save(product), HttpStatus.CREATED);
    }

    public ResponseEntity<Product> getProductById(ProductIdRequest productIdRequest) {
        return new ResponseEntity<>(productDao.findByProductId(productIdRequest.getProductId()), HttpStatus.OK);
    }
}
