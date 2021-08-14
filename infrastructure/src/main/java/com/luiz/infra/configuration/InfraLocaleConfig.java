package com.luiz.infra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.annotation.PostConstruct;

@Configuration
public class InfraLocaleConfig {
    private final ResourceBundleMessageSource messageSource;

    public InfraLocaleConfig(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void addMessageBaseName() {
        messageSource.addBasenames( "i18n/infra-lang" );
    }
}
