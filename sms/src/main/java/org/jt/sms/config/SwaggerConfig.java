package org.jt.sms.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI(){
        return new OpenAPI().info(getInfo());
    }
    private Info getInfo(){
        var info = new Info();
        info.title("Student Management System");
        info.description("A web application for managing for student records");
        info.version("v1");
        return info;
    }
}
