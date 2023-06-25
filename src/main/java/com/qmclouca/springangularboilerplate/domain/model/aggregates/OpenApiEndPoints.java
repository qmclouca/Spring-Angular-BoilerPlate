package com.qmclouca.springangularboilerplate.domain.model.aggregates;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;

public class OpenApiEndPoints {
    @Bean
    public GroupedOpenApi testApi() {
        return GroupedOpenApi.builder().group("api-v1").packagesToScan("com.qmclouca.springangularboilerplate")
                .pathsToMatch("/test/**").build();
    }
}
