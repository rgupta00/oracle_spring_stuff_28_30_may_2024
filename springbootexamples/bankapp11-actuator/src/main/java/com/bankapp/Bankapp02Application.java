package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "bankapp API", version = "2.0" , description = "Oracle bank API"))
@SpringBootApplication
public class Bankapp02Application {

	public static void main(String[] args) {
		SpringApplication.run(Bankapp02Application.class, args);
	}

}
