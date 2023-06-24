package com.qmclouca.springangularboilerplate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
//@EnableSwagger2
//@EnableSwagger2WebMvc
@ComponentScan("com.qmclouca.springangularboilerplate.model.repository")
@ServletComponentScan("com.qmclouca.springangularboilerplate.model.repository")
public class AppApplication {

   /*
    @Bean
    public CommandLineRunner run(@Autowired ClienteRepository repository) {
        return args -> {
            Cliente cliente = Cliente.builder().cpf("00000000000").nome("Fulano").build();
            repository.save(cliente);
        };
    }
    */


    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(AppApplication.class);
        application.addListeners(new SwaggerConfig());
        application.run(args);
    }
}
