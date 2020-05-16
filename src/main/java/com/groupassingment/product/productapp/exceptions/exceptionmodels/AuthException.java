package com.groupassingment.product.productapp.exceptions.exceptionmodels;

import com.groupassingment.product.productapp.exceptions.ProductAppError;
import org.springframework.http.HttpStatus;

public enum AuthException implements ProductAppError {
    WRONG_EMAIL_ADDRESS("Wrong Email Address",true, HttpStatus.NOT_FOUND.value()),
    WRONG_PASSWORD("Wrong Password",true,HttpStatus.UNAUTHORIZED.value()),
    INVALIED_OR_MODIFYED_TOKEN("This Token Is Invalied Or Modifyed",true,HttpStatus.UNAUTHORIZED.value()),
    EMPTY_TOKEN("Token Is Empty",true,HttpStatus.UNAUTHORIZED.value()),
    No_ACCESS("You Have No Access",true,HttpStatus.UNAUTHORIZED.value()),
    UNAUTHORIZED("Unauthorized",true,HttpStatus.UNAUTHORIZED.value())
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

    AuthException(String message, boolean vissiblity, int status) {
        this.message = message;
        this.vissiblity = vissiblity;
        this.status = status;
    }
}
