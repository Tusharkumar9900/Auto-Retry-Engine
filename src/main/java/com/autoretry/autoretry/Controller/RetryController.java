package com.autoretry.autoretry.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autoretry.autoretry.service.ExternalApiService;

@RestController
@RequestMapping("/retry")
public class RetryController {

    @Autowired
    private ExternalApiService apiService;

    @GetMapping("/test")
    public String testRetry() {
        return apiService.callExternalApi();
    }
}
