package com.armaan.product_service.dto;

import com.armaan.product_service.model.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    private String productName;
    private String productDescription;
    private Double productPrice;
    private Integer categoryId;
    private Integer productStock;

}