package com.armaan.product_service.mapper;

import com.armaan.product_service.dto.ProductRequest;
import com.armaan.product_service.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "productId", ignore = true)
    Product toEntity(ProductRequest productRequest);
}
