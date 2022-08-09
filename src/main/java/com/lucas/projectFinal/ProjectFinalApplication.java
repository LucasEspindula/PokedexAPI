package com.lucas.projectFinal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@OpenAPIDefinition
@SpringBootApplication
public class ProjectFinalApplication {
	public static void main(String[] args) {
		SpringApplication.run(ProjectFinalApplication.class, args);
	}
}
