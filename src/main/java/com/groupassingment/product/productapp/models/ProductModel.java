package com.groupassingment.product.productapp.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ProductModel {

    private String ownerId;
    private String categoryId;
    @Id
    private String id;
    private String name;
    private Float price;
    private Float discount;
    private Float netPrice;
    private String categoryName;
}
