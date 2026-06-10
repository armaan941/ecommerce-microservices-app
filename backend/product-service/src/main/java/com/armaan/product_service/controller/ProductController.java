package com.armaan.product_service.controller;

import com.armaan.product_service.dto.ProductIdRequest;
import com.armaan.product_service.dto.ProductRequest;
import com.armaan.product_service.dto.ProductResponse;
import com.armaan.product_service.model.Product;
import com.armaan.product_service.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:5173")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("get-products")
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/add-product")
    public ResponseEntity<Product> addProduct(@RequestBody ProductRequest productRequest) {
        return productService.addProduct(productRequest);
    }

    @PostMapping("/add-products")
    public ResponseEntity<List<Product>> addProducts(@RequestBody List<ProductRequest> productRequests) {
        return productService.addProducts(productRequests);
    }

    @PostMapping("/get-product")
    public ResponseEntity<ProductResponse> getProductById(@RequestBody ProductIdRequest productIdRequest) {
        return productService.getProductById(productIdRequest);
    }

}
