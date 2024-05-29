package com.bankapp.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.bankapp"})
public class Bankapp01Application {

	public static void main(String[] args) {
		SpringApplication.run(Bankapp01Application.class, args);
	}

}
