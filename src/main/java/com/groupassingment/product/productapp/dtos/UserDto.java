package com.groupassingment.product.productapp.dtos;

import lombok.Data;

@Data
public class UserDto {
    private String id;
    private String name;
    private String email;
    private Integer role;
    private String password;

    @Override
    public String toString() {
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", email: '" + email + '\'' +
                ", role: " + role +
                ", password: '" + password + '\'' +
                '}';
    }
}
