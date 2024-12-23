package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.simone.mapper")
public class SpringBootProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProjApplication.class, args);
	}

}
