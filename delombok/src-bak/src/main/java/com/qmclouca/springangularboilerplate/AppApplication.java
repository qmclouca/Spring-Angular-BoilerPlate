package com.qmclouca.springangularboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.qmclouca.springangularboilerplate.rest"),
        @ComponentScan("com.qmclouca.springangularboilerplate.model.repository"),
        @ComponentScan("com.qmclouca.springangularboilerplate.model.entity"),
        @ComponentScan("com.qmclouca.springangularboilerplate.annotations")
})
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
