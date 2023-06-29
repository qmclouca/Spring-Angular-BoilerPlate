package com.qmclouca.springangularboilerplate;

import com.qmclouca.springangularboilerplate.annotations.Development;
import com.qmclouca.springangularboilerplate.annotations.Homologation;
import com.qmclouca.springangularboilerplate.annotations.Production;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.parser.OpenAPIV3Parser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class GeneralConfigurarion implements WebMvcConfigurer {

    private static final String SWAGGER_UI_PATH = "swagger.html";
    private static final String SWAGGER_UI_RESOURCES_PATH = "/webjars/swagger-ui";

    @Bean
    @Development
    public CommandLineRunner executeDev(){
        return args -> System.out.println("Rodando em DEV");
    }
    @Bean
    @Homologation
    public CommandLineRunner executeHTML(){
        return args -> System.out.println("Rodando em HML");
    }
    @Bean
    @Production
    public CommandLineRunner executePRD(){
        return args -> System.out.println("Rodando em PRD");
    }

    @Bean
    public OpenAPI openAPI() {
        String yamlPath = "src/main/Resources/Spring_Angular_BoilerPlate-openapi.yaml"; // Adjust the path to your YAML file
        OpenAPI openAPI = new OpenAPIV3Parser().read(yamlPath);
        return openAPI;
    }

    /*
    @Bean
    public OpenApiCustomiser openApiCustomiser(OpenAPI openAPI) {
        return openAPI -> {
            // Customize the OpenAPI object if needed
        };
    }
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(SWAGGER_UI_PATH)
                .addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler(SWAGGER_UI_RESOURCES_PATH + "/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/swagger-ui/");
    }
}