package com.example.liteMode;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class AppConfig3 {
    @Bean
    public ObjectMapper objectMapperLiteBeanInjection() {
        return new ObjectMapper();
    }

    @Bean
    public ObjectMapper anyobjectMapperLiteBeanInjection(ObjectMapper objectMapperLiteBeanInjection) {
        return objectMapperLiteBeanInjection;
    }
}
