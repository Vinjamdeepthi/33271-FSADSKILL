package com.klu.config;


import io.swagger.v3.oas.models.*;
import io.swagger.v3.oas.models.info.*;
import org.springframework.context.annotation.*;

@Configuration
public class SwaggerConfig 
{

    @Bean
    public OpenAPI customOpenAPI() 
    {
        return new OpenAPI()
                .info(new Info()
                        .title("Student CRUD API")
                        .version("1.0")
                        .description("Swagger Documentation for Student CRUD"));
    }
}