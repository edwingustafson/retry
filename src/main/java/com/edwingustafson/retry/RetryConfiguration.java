package com.edwingustafson.retry;

import java.util.Random;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RetryConfiguration {
    @Bean
    public Random random() {
        return new Random();
    }
}
