package com.luiz.api.utils;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

@Component
public class CustomMessageSource {
    private static MessageSource messageSource;

    private final MessageSource ms;

    public CustomMessageSource(MessageSource messageSource) {
        this.ms = messageSource;
    }

    public static String getMessage(String key, Locale locale) {
        try {
            return messageSource.getMessage(key, null, locale);
        } catch (Exception ex) {
            return key;
        }
    }

    @PostConstruct
    private void setupStatic() {
        CustomMessageSource.messageSource = ms;
    }

}
