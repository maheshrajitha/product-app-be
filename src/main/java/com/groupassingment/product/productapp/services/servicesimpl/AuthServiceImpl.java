package com.groupassingment.product.productapp.services.servicesimpl;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.groupassingment.product.productapp.dtos.UserDto;
import com.groupassingment.product.productapp.exceptions.ProductAppException;
import com.groupassingment.product.productapp.exceptions.exceptionmodels.AuthException;
import com.groupassingment.product.productapp.models.UserModel;
import com.groupassingment.product.productapp.repository.UserRepository;
import com.groupassingment.product.productapp.services.AuthService;
import com.groupassingment.product.productapp.util.Mapper;
import com.groupassingment.product.productapp.util.PasswordFactory;
import com.groupassingment.product.productapp.util.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordFactory passwordFactory;
    @Autowired
    private Mapper mapper;
    @Autowired
    private Gson gson;
    @Autowired
    private TokenFactory tokenFactory;

    @Override
    public String login(UserDto userDto){
        UserModel userModel = userRepository.findByEmail(userDto.getEmail());
        if(userModel != null){
            if(passwordFactory.checkBcryptPassword(userDto.getPassword() , userModel.getPassword())) {
                Map<String, Object> credentials = new HashMap<>();
                userDto = mapper.userModelToUserDto(userDto,userModel);
                credentials.put("user",userDto);
                credentials.put("token",tokenFactory.createJwtToken(userDto));
                return gson.toJson(credentials);
            }
            else
                throw new ProductAppException(AuthException.WRONG_PASSWORD);
        }else
            throw new ProductAppException(AuthException.WRONG_EMAIL_ADDRESS);
    }
}
