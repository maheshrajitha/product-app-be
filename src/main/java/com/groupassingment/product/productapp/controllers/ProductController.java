package com.groupassingment.product.productapp.controllers;

import com.groupassingment.product.productapp.annotations.AuthenticetionScope;
import com.groupassingment.product.productapp.dtos.ProductDto;
import com.groupassingment.product.productapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductController implements Controller {
    @Autowired
    private ProductService productService;

    @PostMapping
    @AuthenticetionScope(3)
    public ResponseEntity<?> addNewProduct(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.saveProduct(productDto));
    }

    @GetMapping("/all")
    @AuthenticetionScope(3)
    public ResponseEntity<?> getMyAllProducts(){
        return ResponseEntity.ok(productService.getProductsByUser());
    }

    @PatchMapping("/add-discounts")
    @AuthenticetionScope(3)
    public ResponseEntity<?> addDiscount(@RequestBody ProductDto productDto){
        return ResponseEntity.ok(productService.addDiscount(productDto));
    }
}
