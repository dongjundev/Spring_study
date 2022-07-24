package com.example.liteMode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
public class AppConfig2 {
    @Bean
    public ObjectMapper objectMapperLiteBean() {
        return new ObjectMapper();
    }

    @Bean
    public ObjectMapper anyobjectMapperLiteBean() {
        return objectMapperLiteBean();
    }
}
