package com.groupassingment.product.productapp.exceptions.exceptionmodels;

import com.groupassingment.product.productapp.exceptions.ProductAppError;
import org.springframework.http.HttpStatus;

public enum UserException implements ProductAppError {

    THIS_EMAIL_ALREADY_EXISTS("This Email Already Exists",true, HttpStatus.CONFLICT.value())
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

    UserException(String message, boolean vissiblity, int status) {
        this.message = message;
        this.vissiblity = vissiblity;
        this.status = status;
    }
}
