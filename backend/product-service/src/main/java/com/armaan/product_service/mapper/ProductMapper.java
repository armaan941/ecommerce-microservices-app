package com.armaan.product_service.mapper;

import com.armaan.product_service.dto.CategoryResponse;
import com.armaan.product_service.dto.ProductRequest;
import com.armaan.product_service.dto.ProductResponse;
import com.armaan.product_service.model.Category;
import com.armaan.product_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "productId", ignore = true)
    @Mapping(target = "category.categoryId", source = "categoryId")
    Product toEntity(ProductRequest productRequest);

    @Mapping(source = "category.categoryName", target = "categoryName")
    @Mapping(source = "category.parentCategory.categoryName", target = "parentCategoryName")
    ProductResponse toResponse(Product product);

    List<ProductResponse> toResponseList(List<Product> products);

    @Mapping(source = "parentCategory.categoryName", target = "parentCategoryName")
    CategoryResponse toCategoryResponse(Category category);

    List<CategoryResponse> toCategoryResponseList(List<Category> categories);

}
