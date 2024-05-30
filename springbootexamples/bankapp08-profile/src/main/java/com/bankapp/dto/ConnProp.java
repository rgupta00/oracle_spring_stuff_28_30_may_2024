package com.bankapp.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix="spring.datasource")
public class ConnProp {
	private String url;
	private String username;
	private String password;
	private String driverClassName;
}
