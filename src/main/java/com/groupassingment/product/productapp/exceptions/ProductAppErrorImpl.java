package com.groupassingment.product.productapp.exceptions;

import lombok.Setter;

public class ProductAppErrorImpl implements ProductAppError {

    @Setter
    private String message;
    @Setter
    private boolean vissiblity;
    @Setter
    private  String code;
    @Setter
    private int status;

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
        return code;
    }

    @Override
    public int getStatus() {
        return status;
    }
}
