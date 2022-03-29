package com.example.H2test;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = H2testApplication.class)
@SpringBootApplication
public class H2testApplication {

	public static void main(String[] args) {
		SpringApplication.run(H2testApplication.class, args);
	}

}
