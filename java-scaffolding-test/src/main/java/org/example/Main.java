package org.example;

import com.test.common.exception.GlobalExceptionHandler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

//
@SpringBootApplication(scanBasePackages = "com.test.common.swagger", exclude = {DataSourceAutoConfiguration.class})
/*
@SpringBootApplication(scanBasePackages = {"com.test.common.swagger",
                                            "org.example.controller",
                                            "org.example.service",
                                            "org.example.repository",  },
                        exclude = {DataSourceAutoConfiguration.class})

 */
// Trigger exception handling
@Import(GlobalExceptionHandler.class)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        SpringApplication.run(Main.class, args);
    }
}