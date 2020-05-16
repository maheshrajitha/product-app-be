package com.groupassingment.product.productapp.util;

import lombok.Data;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@Data
@RequestScope
public class ActiveUser {

    private String id;
    private Integer role;
}
