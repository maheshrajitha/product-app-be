package com.groupassingment.product.productapp.services;

import com.groupassingment.product.productapp.dtos.UserDto;

import java.util.Map;

public interface AuthService {

    String login(UserDto userDto);
}
