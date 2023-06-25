package com.qmclouca.springangularboilerplate.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@SpringBootApplication(
        scanBasePackages = {
                "com.qmclouca.springangularboilerplate.domain.model.entities",
                "com.qmclouca.springangularboilerplate.domain.service"
})
@EnableJpaRepositories("com.qmclouca.springangularboilerplate.domain.model.entities")
public class AppApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
