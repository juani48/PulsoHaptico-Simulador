package com.pulsohaptico.bridge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    @Bean
    public OpenAPI bridgeOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Pulso Haptico Bridge API")
                        .description("API para consultar el estado actual del simulador vibro-tactil.")
                        .version("1.0.0"));
    }
}
