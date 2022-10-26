package com.springboot.curso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenApiConf {
	
	@Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI().info(new Info().title("Crud API Rest")
            .version("1.0.0")
            .description("Api para el curso de restapi")
            .termsOfService("http://swagger.io/terms/")
            .license(new License().name("Apache 2.0")
                .url("http://localhost:8080")));
    }
	
}
