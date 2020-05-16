package com.groupassingment.product.productapp.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
@Data
public class UserModel {
    @Id
    private String id;
    private String name;
    private String email;
    private Integer role;
    private String password;
}
