package com.autoretry.autoretry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class AutoretryApplication {

	public static void main(String[] args) {
		SpringApplication.run(AutoretryApplication.class, args);
	}

}
