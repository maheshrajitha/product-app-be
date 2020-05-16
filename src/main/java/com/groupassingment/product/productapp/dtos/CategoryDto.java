package com.groupassingment.product.productapp.dtos;

import lombok.Data;

import java.util.Date;

@Data
public class CategoryDto {

    private String ownerId;
    private String id;
    private String category;
    private Date addedDate;
}
