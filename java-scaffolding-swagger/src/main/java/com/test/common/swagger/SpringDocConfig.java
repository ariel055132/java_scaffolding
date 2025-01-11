package com.test.common.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class SpringDocConfig {
    @Bean
    public OpenAPI baseOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Base Documentation")
                        .description("Base API Documentation")
                        .version("1.0.0")
                        .license(new License().name("Your License").url("http://springdoc.org"))
                        .contact(new Contact().name("Your Name").email("ex").url("http://springdoc.org"))
                );
    }
}
