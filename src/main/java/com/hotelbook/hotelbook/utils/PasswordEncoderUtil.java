package com.hotelbook.hotelbook.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordEncoderUtil {
    @Bean
    public static BCryptPasswordEncoder getInstance(){
        return new BCryptPasswordEncoder();
    }
}