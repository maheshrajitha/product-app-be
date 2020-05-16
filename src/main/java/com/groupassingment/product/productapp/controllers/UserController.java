package com.groupassingment.product.productapp.controllers;

import com.groupassingment.product.productapp.dtos.UserDto;
import com.groupassingment.product.productapp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController implements Controller {

    @Autowired
    private UserService userService;
    @PostMapping
    public ResponseEntity<?> saveNewUser(@RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.saveNewUser(userDto));
    }
}
