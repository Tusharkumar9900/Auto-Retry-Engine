package com.autoretry.autoretry.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import com.autoretry.autoretry.annotation.AutoRetry;
import com.autoretry.autoretry.exception.RetryableException;


@Component
@Aspect
public class RetryAspect {
    
     @Around("@annotation(autoRetry)")
    public Object retry(ProceedingJoinPoint joinPoint, AutoRetry autoRetry) throws Throwable {
        int attempts = autoRetry.attempts();
        long delay = autoRetry.delay();

        int currentAttempt = 1;

        while (currentAttempt <= attempts) {
            try {
                System.out.println("Attempt " + currentAttempt + " running...");
                return joinPoint.proceed();
            } catch (RetryableException e) {
                System.out.println("Retryable error: " + e.getMessage());

                if (currentAttempt == attempts) {
                    System.out.println("Max attempts reached. Throwing error.");
                    throw e;
                }

                long backoff = delay * currentAttempt;
                System.out.println("Retrying in " + backoff + " ms...");
                Thread.sleep(backoff);
            }
            currentAttempt++;
        }

        return null;
    }
}
