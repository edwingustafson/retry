package com.edwingustafson.retry;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;

@EnableRetry
@SpringBootApplication
public class RetryApplication {
	private final RetryService retryService;

	public RetryApplication(final RetryService retryService) {
		this.retryService = retryService;
	}

	public static void main(final String[] args) {
		SpringApplication.run(RetryApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			String.format("Result: %d", retryService.retry());
		};
	}
}
