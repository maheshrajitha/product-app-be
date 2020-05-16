package com.groupassingment.product.productapp.exceptions;

public interface ProductAppError {

    String getMessage();
    String getCode();
    int getStatus();
    boolean isVissibility();
}
