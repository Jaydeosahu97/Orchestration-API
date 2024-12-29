package com.jay.orchestration;

import com.jay.orchestration.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrchestrationApiApplication {

	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(OrchestrationApiApplication.class, args);
	}

	@PostConstruct
	public void init(){
		userService.addAllUsers();
	}
}
