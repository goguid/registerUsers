package cl.muruna.registerUsers.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customApi(){
        return new OpenAPI().info(new Info()
                                    .title("Registro de usuarios - Prueba java")
                                    .version("1.0.0")
                                    .description("Api rest que maneja la informacion del usuario")
                                    .termsOfService("http://swagger.io/terms/")
                                    .license(new License().name("Apache 2.0").url("http://springdoc.org")));
    }
}
