package com.armaan.product_service.service;

import com.armaan.product_service.dao.CategoryDao;
import com.armaan.product_service.dao.ProductDao;
import com.armaan.product_service.dto.CategoryIdRequest;
import com.armaan.product_service.dto.ProductIdRequest;
import com.armaan.product_service.dto.ProductRequest;
import com.armaan.product_service.dto.ProductResponse;
import com.armaan.product_service.exception.ProductNotFoundException;
import com.armaan.product_service.mapper.ProductMapper;
import com.armaan.product_service.model.Category;
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
    CategoryDao categoryDao;

    @Autowired
    ProductMapper productMapper;

    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        List<Product> products = productDao.findAll();
        List<ProductResponse> responses = productMapper.toResponseList(products);

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }

    public ResponseEntity<Product> addProduct(ProductRequest productRequest) {
        Product product = productMapper.toEntity(productRequest);
        Category category = categoryDao.findById(productRequest.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return new ResponseEntity<>(productDao.save(product), HttpStatus.CREATED);
    }

    public ResponseEntity<List<Product>> addProducts(List<ProductRequest> productRequests) {
        List<Product> products = new ArrayList<>();
        for (ProductRequest productRequest : productRequests) {
            Product product = productMapper.toEntity(productRequest);
            Category category = categoryDao.findById(productRequest.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            product.setCategory(category);
            products.add(product);
        }
        return new ResponseEntity<>(productDao.saveAll(products), HttpStatus.CREATED);
    }

    public ResponseEntity<ProductResponse> getProductById(ProductIdRequest productIdRequest) {
        Product product = productDao.findByProductId(productIdRequest.getProductId());
        ProductResponse productResponse = productMapper.toResponse(product);

        return new ResponseEntity<>(productResponse, HttpStatus.OK);
    }

    public ResponseEntity<List<ProductResponse>> getProductsByCategoryId(CategoryIdRequest categoryIdRequest) {

        List<Product> products = productDao.findAllByCategory_CategoryId(categoryIdRequest.getCategoryId());
        List<ProductResponse> productResponses = new ArrayList<>();
        for (Product product : products) {
            ProductResponse response = productMapper.toResponse(product);
            productResponses.add(response);
        }

        return new ResponseEntity<>(productResponses, HttpStatus.OK);
    }
}
