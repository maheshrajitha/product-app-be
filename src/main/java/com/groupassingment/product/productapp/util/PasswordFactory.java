package com.groupassingment.product.productapp.util;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class PasswordFactory {

    public String hashBcrypt(String plainPassword){
        return BCrypt.hashpw(plainPassword,BCrypt.gensalt(10));
    }

    public boolean checkBcryptPassword(String plainPassword , String hashedPassword){
        return BCrypt.checkpw(plainPassword , hashedPassword);
    }
}
