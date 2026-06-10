package com.armaan.product_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private String productId;
    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer productStock;
    private String categoryName;
    private String parentCategoryName;
}