package com.example.smlouvy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SmlouvyApplication {

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        ConfigurableApplicationContext ctx = SpringApplication.run(SmlouvyApplication.class, args);
    }
}
