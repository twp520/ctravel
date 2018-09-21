package com.colin.ctravel;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
//@SpringBootConfiguration
@MapperScan("com.colin.ctravel.dao")
public class CtravelApplication extends SpringBootServletInitializer{

    public static void main(String[] args) {
        SpringApplication.run(CtravelApplication.class, args);
    }

   /* @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CtravelApplication.class);
    }*/

}
