package com.example.mybatis2.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class ServiceTest {

    @Autowired
    ImageService imageService;
    @Autowired
    MetaboxingService metaboxingService;

    @Test
    void selectTest() {
        System.out.println("metabxoingService: " + metaboxingService.getAllMetaboxing());
        System.out.println("imageService: " + imageService.getAllImage());
    }

    @Test
    @Transactional("oraTransactionManager")
    void insertTest() {
        metaboxingService.insertTest();
    }
}