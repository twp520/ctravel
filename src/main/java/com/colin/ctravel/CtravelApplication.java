package com.colin.ctravel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.colin.ctravel.dao")
public class CtravelApplication {

	public static void main(String[] args) {
		SpringApplication.run(CtravelApplication.class, args);
	}
}
