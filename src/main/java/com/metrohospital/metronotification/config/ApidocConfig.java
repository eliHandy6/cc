package com.metrohospital.metronotification.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@OpenAPIDefinition
@Configuration
public class ApidocConfig {
    @Bean
    public OpenAPI baseOpenAPI() throws IOException {

        Components components = new Components();

        return new OpenAPI()
                .components(components)
                .info(new Info().title("Metropolitan Notification Service").
                        version("1.0.0").description("Metropolitan Notification Service"));
    }

    @Bean
    public GroupedOpenApi authenticationApi() {
        String[] paths = {"/apis/v1/emails/**"};
        return GroupedOpenApi.builder()
                .group("Emails")
                .pathsToMatch(paths)
                .build();
    }


    @Bean
    public GroupedOpenApi roleApi() {
        String[] paths = {"/api/v1/sms/**"};
        return GroupedOpenApi.builder()
                .group("Sms")
                .pathsToMatch(paths)
                .build();
    }

}
