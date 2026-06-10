package com.armaan.product_service.dao;

import com.armaan.product_service.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, Integer> {
}
