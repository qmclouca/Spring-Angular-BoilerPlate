package com.qmclouca.springangularboilerplate.domain.model.aggregates;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class OpenApiEndPoints {
    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder().packagesToScan("com.qmclouca.springangularboilerplate.application.controllers").build();
    }
}
