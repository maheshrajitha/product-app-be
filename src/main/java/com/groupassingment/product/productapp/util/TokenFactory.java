package com.groupassingment.product.productapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.groupassingment.product.productapp.dtos.UserDto;
import com.groupassingment.product.productapp.exceptions.ProductAppException;
import com.groupassingment.product.productapp.exceptions.exceptionmodels.AuthException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
@Slf4j
public class TokenFactory {

    @Autowired
    private Algorithm algorithm;

    public String createJwtToken(UserDto userDto){
        return JWT.create().withClaim("role",userDto.getRole())
                .withClaim("userId",userDto.getId())
                .withJWTId(UUID.randomUUID().toString())
                .withIssuedAt(new Date()).sign(algorithm);
    }

    public DecodedJWT verifyToken(String token){
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        try {
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            return decodedJWT;
        }catch (JWTVerificationException e){
          log.error("Jwt Verification Error {}",e.getMessage());
          throw new ProductAppException(AuthException.INVALIED_OR_MODIFYED_TOKEN);
        }
    }
}
