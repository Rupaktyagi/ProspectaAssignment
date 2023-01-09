package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ProspectaAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProspectaAssignmentApplication.class, args);
	}

	
	@Bean
	public RestTemplate createObj() {
		
		return new RestTemplate();
	}
	
}
