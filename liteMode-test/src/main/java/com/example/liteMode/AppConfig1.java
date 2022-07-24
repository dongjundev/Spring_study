package com.example.liteMode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig1 {
    @Bean
    public ObjectMapper objectMapperBean() {
        return new ObjectMapper();
    }

    @Bean
    public ObjectMapper anyObjectMapperBean() {
        return objectMapperBean();
    }
}
