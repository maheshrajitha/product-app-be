package com.groupassingment.product.productapp.exceptions.exceptionmodels;

import com.groupassingment.product.productapp.exceptions.ProductAppError;
import org.springframework.http.HttpStatus;

public enum ProductException implements ProductAppError {
    PRODUCT_NOT_FOUND("Product Not Found",true, HttpStatus.NOT_FOUND.value())
    ;
    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public boolean isVissibility() {
        return vissiblity;
    }

    @Override
    public String getCode() {
        return this.name();
    }

    @Override
    public int getStatus() {
        return status;
    }

    private String message;
    private boolean vissiblity;
    private int status;

    ProductException(String message, boolean vissiblity, int status) {
        this.message = message;
        this.vissiblity = vissiblity;
        this.status = status;
    }
}
