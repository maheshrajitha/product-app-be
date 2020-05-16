package com.groupassingment.product.productapp.services.servicesimpl;

import com.groupassingment.product.productapp.dtos.UserDto;
import com.groupassingment.product.productapp.exceptions.ProductAppException;
import com.groupassingment.product.productapp.exceptions.exceptionmodels.UserException;
import com.groupassingment.product.productapp.models.UserModel;
import com.groupassingment.product.productapp.repository.UserRepository;
import com.groupassingment.product.productapp.services.UserService;
import com.groupassingment.product.productapp.util.Mapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private Mapper mapper;

    @Override
    public UserDto saveNewUser(UserDto userDto) {
        UserModel userModel = userRepository.findByEmail(userDto.getEmail());
        if(userModel == null) {
            userModel = mapper.userDtoToUserModel(userDto);
            userRepository.save(userModel);
            return userDto;
        }else
            throw new ProductAppException(UserException.THIS_EMAIL_ALREADY_EXISTS);
    }
}
