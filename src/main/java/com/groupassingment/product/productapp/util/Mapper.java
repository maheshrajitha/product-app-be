package com.groupassingment.product.productapp.util;

import com.groupassingment.product.productapp.dtos.CategoryDto;
import com.groupassingment.product.productapp.dtos.ProductDto;
import com.groupassingment.product.productapp.dtos.UserDto;
import com.groupassingment.product.productapp.models.CategoryModel;
import com.groupassingment.product.productapp.models.ProductModel;
import com.groupassingment.product.productapp.models.UserModel;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class Mapper {

    public UserModel userDtoToUserModel(UserDto userDto){
        UserModel userModel = new UserModel();
        userModel.setEmail(userDto.getEmail());
        userModel.setName(userDto.getName());
        userDto.setId(UUID.randomUUID().toString());
        userModel.setId(userDto.getId());
        userDto.setRole(1);
        userModel.setRole(userDto.getRole());
        userModel.setPassword(new PasswordFactory().hashBcrypt(userDto.getPassword()));
        return userModel;
    }

    public UserDto userModelToUserDto(UserDto userDto , UserModel userModel){
        userDto.setRole(userModel.getRole());
        userDto.setId(userModel.getId());
        userDto.setEmail(userModel.getEmail());
        userDto.setName(userModel.getName());
        return userDto;
    }

    public CategoryDto mapCategoryModelToCategoryDto(CategoryDto categoryDto , CategoryModel categoryModel){
        categoryDto.setAddedDate(categoryModel.getAddedDate());
        categoryDto.setCategory(categoryModel.getCategory());
        categoryDto.setId(categoryModel.getId());
        categoryDto.setOwnerId(categoryModel.getOwnerId());
        return categoryDto;
    }

    public CategoryModel mapCategoryDtoToCategoryModel(CategoryDto categoryDto){
        CategoryModel categoryModel = new CategoryModel();
        categoryDto.setAddedDate(new Date());
        categoryModel.setAddedDate(categoryDto.getAddedDate());
        categoryModel.setCategory(categoryDto.getCategory());
        categoryDto.setId(UUID.randomUUID().toString());
        categoryModel.setId(categoryDto.getId());
        categoryModel.setOwnerId(categoryDto.getOwnerId());
        return categoryModel;
    }

    public ProductModel productDtoToProductModel(ProductDto productDto){
        ProductModel productModel = new ProductModel();
        productModel.setCategoryId(productDto.getCategoryId());
        productModel.setDiscount(productDto.getDiscount());
        productDto.setId(UUID.randomUUID().toString());
        productModel.setId(productDto.getId());
        productModel.setName(productDto.getName());
        productModel.setNetPrice(productDto.getNetPrice());
        productModel.setPrice(productDto.getPrice());
        productModel.setOwnerId(productDto.getOwnerId());
        productModel.setCategoryName(productDto.getCategoryName());
        return productModel;
    }

    public ProductDto productModelToProductDto(ProductDto productDto , ProductModel productModel){
        productDto.setId(productModel.getId());
        productDto.setCategoryId(productModel.getCategoryId());
        productDto.setCategoryName(productModel.getCategoryName());
        productDto.setDiscount(productModel.getDiscount());
        productDto.setName(productModel.getName());
        productDto.setNetPrice(productModel.getNetPrice());
        productDto.setOwnerId(productModel.getOwnerId());
        productDto.setPrice(productModel.getPrice());
        return productDto;
    }
}
