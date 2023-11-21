package com.example.centralapplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class CentralApplication {

	@Bean
	public WebClient webClient() {
		return WebClient.create();
	}

	public static void main(String[] args) {
		SpringApplication.run(CentralApplication.class, args);
	}


}
