package com.groupassingment.product.productapp.interceptors;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.groupassingment.product.productapp.annotations.AuthenticetionScope;
import com.groupassingment.product.productapp.exceptions.ProductAppException;
import com.groupassingment.product.productapp.exceptions.exceptionmodels.AuthException;
import com.groupassingment.product.productapp.util.ActiveUser;
import com.groupassingment.product.productapp.util.TokenFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenFactory tokenFactory;
    @Autowired
    private ActiveUser activeUser;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            if(request.getHeader("Authorization") != null && handlerMethod.hasMethodAnnotation(AuthenticetionScope.class)){
                DecodedJWT decodedJWT = tokenFactory.verifyToken(request.getHeader("Authorization").replace("Bearer ",""));
                if(decodedJWT.getClaim("role").asInt() <= handlerMethod.getMethodAnnotation(AuthenticetionScope.class).value()){
                    activeUser.setId(decodedJWT.getClaim("userId").asString());
                    activeUser.setRole(decodedJWT.getClaim("role").asInt());
                    return true;
                }else
                    throw new ProductAppException(AuthException.No_ACCESS);
            }else if (!handlerMethod.hasMethodAnnotation(AuthenticetionScope.class)){
                return true;
            }
        }
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        return false;
    }
}
