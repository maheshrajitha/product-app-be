package com.groupassingment.product.productapp.services;

import com.groupassingment.product.productapp.dtos.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto addNewCategory(CategoryDto categoryDto);
    List<CategoryDto> getCategoryByOwner();
    boolean deleteCategory(String categoryId);
}
