package com.luiz.api.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class CustomMessageSource {
    private static MessageSource messageSource;

    public static String getMessage(String key, Locale locale) {
        try {
            return messageSource.getMessage(key, null, locale);
        } catch (Exception ex) {
            return key;
        }
    }

    @Autowired
    public void setMessageSource(MessageSource messageSource) {
        CustomMessageSource.setStaticMessageSource(messageSource);
    }

    private static void setStaticMessageSource(MessageSource messageSource) {
        CustomMessageSource.messageSource = messageSource;
    }

}
