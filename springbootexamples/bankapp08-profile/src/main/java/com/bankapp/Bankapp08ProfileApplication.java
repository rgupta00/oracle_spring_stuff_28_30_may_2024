package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.bankapp.dto.ConnProp;
@EnableConfigurationProperties(ConnProp.class)
@SpringBootApplication
public class Bankapp08ProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bankapp08ProfileApplication.class, args);
	}

}
