package com.kakadurf.cv4.framework.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicUserApi() {
        return GroupedOpenApi.builder()
                .group("Users")
                .pathsToMatch("/**")
                .build();
    }

    @Bean
    public OpenAPI customOpenApi(@Value("${application-description}")
                                             String appDescription,
                                 @Value("${application-version}")
                                         String appVersion) {

        return new OpenAPI().info(new Info().title("Application API")
                .version(appVersion)
                .description(appDescription)
                .license(new License().name("Apache 2.0")
                        .url("https://springdoc.org"))
                .contact(new Contact().name("Galiev Bulat")
                        .email("galievbulat2001@gmail.com")))
                .servers(Arrays.stream(new Server[]{new Server().url("http://localhost")
                        .description("Music site")}).collect(Collectors.toList()));
    }
}
