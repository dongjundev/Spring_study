package com.example.mybatis2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServiceTest {

    @Autowired
    ImageService imageService;
    @Autowired
    MetaboxingService metaboxingService;

    @Test
    void selectTest() {
        System.out.println(metaboxingService.getAllMetaboxing());
//        System.out.println(imageService.getClass());
        System.out.println(imageService.getAllImage());
    }
}