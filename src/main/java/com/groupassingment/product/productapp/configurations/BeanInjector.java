package com.groupassingment.product.productapp.configurations;

import com.auth0.jwt.algorithms.Algorithm;
import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanInjector {

    public final static String SIGNATURE = "sbafhgsagf";
    @Bean
    public Gson getGson(){
        return new Gson();
    }

    @Bean
    public Algorithm getAlgorithm(){
        return Algorithm.HMAC256(SIGNATURE);
    }


}
