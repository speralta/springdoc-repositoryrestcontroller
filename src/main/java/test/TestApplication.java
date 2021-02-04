package test;

import java.util.ArrayList;
import java.util.Arrays;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@SpringBootApplication
public class TestApplication {

    public static void main(String... args) {
        SpringApplication.run(TestApplication.class, args);
    }

    @Bean
    public OpenAPI swaggerOpenApi() {
        final String securitySchemeName = "bearerAuth";
        SecurityRequirement securityRequirement = new SecurityRequirement();
        securityRequirement.put(securitySchemeName, new ArrayList<>());
        return new OpenAPI().info(new Info().title("Test API").description("Endpoints documentation").version("0.0.1"))
                .security(Arrays.asList(securityRequirement))
                .components(new Components().addSecuritySchemes(securitySchemeName,
                        new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("UUID")));
    }

    @Bean
    public GroupedOpenApi swaggerPublicOpenApi() {
        return GroupedOpenApi.builder().group("public").pathsToMatch("/**").build();
    }

}
