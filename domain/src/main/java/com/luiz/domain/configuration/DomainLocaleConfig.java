package com.luiz.domain.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import javax.annotation.PostConstruct;

@Configuration
public class DomainLocaleConfig {
    private final ReloadableResourceBundleMessageSource messageSource;

    public DomainLocaleConfig(ReloadableResourceBundleMessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @PostConstruct
    public void addMessageBaseName() {
        messageSource.addBasenames( "classpath:/i18n/domain-lang" );
    }
}
