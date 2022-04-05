package com.example.mybatis2;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan(basePackageClasses = Mybatis2Application.class)
public class Mybatis2Application {

	public static void main(String[] args) {
		SpringApplication.run(Mybatis2Application.class, args);
	}

}
