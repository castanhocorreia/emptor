package io.platformbuilders.customers.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    public OpenAPI customOpenAPI(@Value("${application.version}") String version) {
        return new OpenAPI()
                .info(
                        new Info()
                                .title("Platform Builders: Customers")
                                .version(version)
                                .description(
                                        "Application built for the Platform Builders challenge")
                                .termsOfService("None")
                                .license(
                                        new License()
                                                .name("GPL-3.0 License")
                                                .url(
                                                        "https://www.gnu.org/licenses/gpl-3.0.en.html"))
                                .contact(
                                        new Contact()
                                                .name("João (Castanho) Correia")
                                                .email("me@castanhocorreia.com")));
    }
}
