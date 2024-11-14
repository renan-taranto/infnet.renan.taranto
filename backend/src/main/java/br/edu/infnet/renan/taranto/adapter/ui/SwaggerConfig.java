package br.edu.infnet.renan.taranto.adapter.ui;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API: Motos")
                        .version("1.0")
                        .description("API para gestão de despesas com motos")
                        .contact(new Contact()
                                .name("Renan Taranto")
                                .email("renantaranto@gmail.com")));
    }
}
