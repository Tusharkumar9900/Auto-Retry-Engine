package com.autoretry.autoretry.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.autoretry.autoretry.annotation.AutoRetry;
import com.autoretry.autoretry.exception.RetryableException;

@Service
public class ExternalApiService {
        private final Random random = new Random();

    @AutoRetry(attempts = 4, delay = 500)
    public String callExternalApi() {
        int num = random.nextInt(10);

        if (num < 7) {
            throw new RetryableException("Failed to call external API. Random number: " + num);
        }

        return "SUCCESS: External API call worked on attempt with number = " + num;
    }
}
