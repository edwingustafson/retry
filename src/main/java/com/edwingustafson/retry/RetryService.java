package com.edwingustafson.retry;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Service
public class RetryService {
    private static final Logger logger = LoggerFactory.getLogger(RetryService.class);

    private final Random random;

    public RetryService(final Random random) {
        this.random = random;
    }

    /**
     * Retryable method that that generates a random integer between 0 and 9. If the
     * result is less than 9, an exception is thrown. The method will be retried up
     * 
     * @return
     * @throws Exception
     */
    @Retryable(value = { Exception.class }, maxAttempts = 10, backoff = @org.springframework.retry.annotation.Backoff(delay = 1000, multiplier = 2))
    public int retry() throws Exception {
        final var result = random.nextInt(10);
        logger.info(String.format("Result: %d", result));

        if (result < 9) {
            throw new Exception(String.format("Insufficient result: %d", result));
        } else {
            return result;
        }
    }
}