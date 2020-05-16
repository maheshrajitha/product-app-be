package com.groupassingment.product.productapp.controllers;

import com.groupassingment.product.productapp.exceptions.ProductAppErrorImpl;
import com.groupassingment.product.productapp.exceptions.ProductAppException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public interface Controller {

    @ExceptionHandler(ProductAppException.class)
    default ResponseEntity<?> exceptionModel(ProductAppException productAppException){
        ProductAppErrorImpl productAppError = new ProductAppErrorImpl();
        productAppError.setCode(productAppException.getProductAppError().getCode());
        productAppError.setMessage(productAppException.getProductAppError().getMessage());
        productAppError.setStatus(productAppException.getProductAppError().getStatus());
        productAppError.setVissiblity(productAppException.getProductAppError().isVissibility());
        return ResponseEntity.status(productAppException.getProductAppError().getStatus()).body(productAppError);
    }
}
