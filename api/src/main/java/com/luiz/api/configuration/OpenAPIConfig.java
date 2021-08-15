package com.luiz.api.configuration;

import io.swagger.v3.oas.models.parameters.HeaderParameter;
import org.springdoc.core.customizers.OpenApiCustomiser;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenApiCustomiser addAcceptLanguageHeader() {
        return openApi -> openApi.getPaths().values().stream().flatMap(pathItem -> pathItem.readOperations().stream())
                .forEach(operation -> operation.addParametersItem(new HeaderParameter().name("Accept-Language")));
    }
}
