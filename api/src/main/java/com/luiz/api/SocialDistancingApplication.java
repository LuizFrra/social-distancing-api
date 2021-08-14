package com.luiz.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.luiz")
public class SocialDistancingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocialDistancingApplication.class, args);
	}

}
