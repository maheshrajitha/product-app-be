package com.groupassingment.product.productapp.models;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class CategoryModel {

    private String ownerId;
    @Id
    private String id;
    private String category;
    private Date addedDate;
}
