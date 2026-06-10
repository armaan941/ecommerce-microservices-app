package com.armaan.product_service.service;

import com.armaan.product_service.dao.CategoryDao;
import com.armaan.product_service.dto.CategoryResponse;
import com.armaan.product_service.mapper.ProductMapper;
import com.armaan.product_service.model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Autowired
    ProductMapper productMapper;

    public ResponseEntity<List<CategoryResponse>> getCategories() {
        List<Category> categories = categoryDao.findAll();
        List<CategoryResponse> responses = productMapper.toCategoryResponseList(categories);

        return new ResponseEntity<>(responses, HttpStatus.OK);
    }
}
