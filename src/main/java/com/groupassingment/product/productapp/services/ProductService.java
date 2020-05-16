package com.groupassingment.product.productapp.services;

import com.groupassingment.product.productapp.dtos.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto saveProduct(ProductDto productDto);
    Float addDiscount(ProductDto productDto);
    List<ProductDto> getProductsByUser();
    boolean deleteProduct(String productId);
}
