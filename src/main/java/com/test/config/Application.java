package com.test.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.test.api","com.test.model","com.test.service","com.test.service.repository"})
public class Application {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(new Class<?>[] {Application.class,JpaConfig.class}, args);
    }
}
