package com.groupassingment.product.productapp.dtos;

import lombok.Data;

@Data
public class ProductDto {

    private String ownerId;
    private String categoryId;
    private String id;
    private String name;
    private Float price;
    private Float discount;
    private Float netPrice;
    private String categoryName;
}
