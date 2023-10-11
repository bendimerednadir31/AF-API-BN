package com.af.api.expose.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static com.af.api.expose.utils.Constants.MESSAGE_PROPERTY_FILE_NAME;
import static com.af.api.expose.utils.Constants.MESSAGE_PROPERTY_FILE_UTF8;

@PropertySource("classpath:messages_en.properties")
@Configuration
@EnableWebMvc
public class AppConfig {

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_PROPERTY_FILE_NAME);
        messageSource.setDefaultEncoding(MESSAGE_PROPERTY_FILE_UTF8);
        return messageSource;
    }

}
