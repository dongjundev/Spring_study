package com.example.liteMode;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class Test {

    @org.junit.jupiter.api.Test
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig1.class);

        Object objectMapperBean = ac.getBean("objectMapperBean");
        Object anyObjectMapperBean = ac.getBean("anyObjectMapperBean");

        System.out.println("objectMapperBean: "+objectMapperBean);
        System.out.println("anyObjectMapperBean: "+anyObjectMapperBean);

        System.out.println("objectMapperBean.getClass(): "+objectMapperBean.getClass());
        System.out.println("anyObjectMapperBean.getClass(): "+anyObjectMapperBean.getClass());

        assertThat(objectMapperBean).isSameAs(anyObjectMapperBean);
    }

    @org.junit.jupiter.api.Test
    void configurationTest2() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig2.class);

        Object objectMapperLiteBean = ac.getBean("objectMapperLiteBean");
        Object anyobjectMapperLiteBean = ac.getBean("anyobjectMapperLiteBean");

        System.out.println("objectMapperLiteBean: "+objectMapperLiteBean);
        System.out.println("anyobjectMapperLiteBean: "+anyobjectMapperLiteBean);

        System.out.println("objectMapperLiteBean.getClass(): "+objectMapperLiteBean.getClass());
        System.out.println("anyobjectMapperLiteBean.getClass(): "+anyobjectMapperLiteBean.getClass());

        assertThat(objectMapperLiteBean).isSameAs(anyobjectMapperLiteBean);
    }

    @org.junit.jupiter.api.Test
    void configurationTest3() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig3.class);

        Object objectMapperLiteBeanInjection = ac.getBean("objectMapperLiteBeanInjection");
        Object anyobjectMapperLiteBeanInjection = ac.getBean("anyobjectMapperLiteBeanInjection");

        System.out.println("objectMapperLiteBeanInjection: "+objectMapperLiteBeanInjection);
        System.out.println("anyobjectMapperLiteBeanInjection: "+anyobjectMapperLiteBeanInjection);

        System.out.println("objectMapperLiteBeanInjection.getClass(): "+objectMapperLiteBeanInjection.getClass());
        System.out.println("anyobjectMapperLiteBeanInjection.getClass(): "+anyobjectMapperLiteBeanInjection.getClass());

        assertThat(objectMapperLiteBeanInjection).isSameAs(anyobjectMapperLiteBeanInjection);
    }
}
