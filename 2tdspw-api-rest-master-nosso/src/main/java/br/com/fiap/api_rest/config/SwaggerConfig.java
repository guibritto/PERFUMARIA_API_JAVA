package br.com.fiap.api_rest.config;

// Importações necessárias para configurar a documentação OpenAPI (Swagger)
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Indica que essa classe é uma configuração do Spring
@Configuration
public class SwaggerConfig {

    // Define um bean (componente gerenciado pelo Spring) que personaliza a documentação da API
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                // Define as informações principais da API que vão aparecer no Swagger UI
                .info(new Info()
                        .title("API da Perfumaria")                 // Título que vai aparecer no topo da doc
                        .version("1.0")                             // Versão da API
                        .description("Documentação da API de perfumes, maquiagens e cuidados.")); // Descrição explicando o propósito da API
    }
}