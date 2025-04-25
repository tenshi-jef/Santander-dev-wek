package me.dio.santander_dev_week_2023.Config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * Configuração do Swagger/OpenAPI para documentação automática da API REST.
 * <p>
 * Esta API expõe múltiplos endpoints para operações relacionadas a:
 * <ul>
 *     <li>Criação e listagem de usuários</li>
 *     <li>Criação de contas bancárias</li>
 *     <li>Associação e emissão de cartões</li>
 *     <li>Consulta de transações financeiras</li>
 * </ul>
 * </p>
 */
@Configuration
public class OpenApiConfig {

    /**
     * Cria a instância personalizada do OpenAPI com as informações da aplicação,
     * como título, descrição, versão, contato e licença.
     *
     * @return Configuração da documentação OpenAPI.
     */
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Santander Dev Week - API de Usuários e Transações")
                        .version("1.0.0")
                        .description("API RESTful para gerenciamento de usuários, contas, cartões e transações bancárias.")
                        .contact(new Contact()
                                .name("Jef Dev")
                                .email("jefersonsf3276@gmail.com")
                                .url("https://santanderdevweek.com"))
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://www.apache.org/licenses/LICENSE-2.0")))
                .servers(List.of(
                        new Server().url("http://localhost:8080").description("Servidor local")
                ));
    }
}