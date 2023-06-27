package com.qmclouca.springangularboilerplate;

import com.qmclouca.springangularboilerplate.annotations.Development;
import com.qmclouca.springangularboilerplate.annotations.Homologation;
import com.qmclouca.springangularboilerplate.annotations.Production;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfigurarion {

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


}