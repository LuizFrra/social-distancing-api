package com.luiz.domain.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.annotation.PostConstruct;

@Configuration
public class DomainLocaleConfig {
    private final ResourceBundleMessageSource messageSource;

    public DomainLocaleConfig(ResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void addMessageBaseName() {
        messageSource.addBasenames( "i18n/domain-lang" );
    }
}
