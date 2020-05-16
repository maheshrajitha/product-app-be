package com.groupassingment.product.productapp.controllers;

import com.groupassingment.product.productapp.dtos.UserDto;
import com.groupassingment.product.productapp.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController implements Controller{

    @Autowired
    private AuthService authService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody UserDto userDto){
        return ResponseEntity.ok(authService.login(userDto));
    }
}
