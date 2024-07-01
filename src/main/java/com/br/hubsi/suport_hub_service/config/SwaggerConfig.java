package com.br.hubsi.suport_hub_service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.br.hubsi.suport_hub_service.controller")) // Altere para o seu pacote base
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Suport Hub Service API")
                .description("Este projeto é uma API REST desenvolvida em Spring Boot 3.3 e Java 17, utilizando MySQL como banco de dados e Docker para containerização. O sistema é destinado ao registro de atendimentos realizados por empresas que prestam serviços via chamada telefônica, além de gerenciar usuários, clientes, contratos e fila de espera.")
                .version("1.0.0")
                .contact(new Contact("Pablo Machado Lima", "linkedin", "https://www.linkedin.com/in/pablo-machado-lima-42820a194"))
                .build();
    }
}