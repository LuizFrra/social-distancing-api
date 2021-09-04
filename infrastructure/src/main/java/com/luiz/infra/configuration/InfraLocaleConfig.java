package com.luiz.infra.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.PostConstruct;

@Configuration
public class InfraLocaleConfig {
    private final ReloadableResourceBundleMessageSource messageSource;

    public InfraLocaleConfig(ReloadableResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void addMessageBaseName() {
        messageSource.addBasenames( "classpath:/i18n/infra-lang" );
    }
}
