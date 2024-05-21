package com.application.healthProtector;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class HealthProtectorApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthProtectorApplication.class, args);
	}

}
