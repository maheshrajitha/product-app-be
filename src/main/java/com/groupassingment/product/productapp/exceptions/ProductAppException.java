package com.groupassingment.product.productapp.exceptions;

public class ProductAppException extends RuntimeException{

    private final ProductAppError productAppError;

    public ProductAppException(ProductAppError productAppError) {
        super(productAppError.getMessage());
        this.productAppError = productAppError;
    }

    public ProductAppError getProductAppError(){
        return this.productAppError;
    }
}
