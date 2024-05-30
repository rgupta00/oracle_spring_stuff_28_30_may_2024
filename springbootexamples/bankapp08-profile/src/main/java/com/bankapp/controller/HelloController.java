package com.bankapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.ConnProp;

@RestController
public class HelloController {

//	@Value("${spring.datasource.url}")
//	private String url;
//	
	
	@Autowired
	private ConnProp connProp;
	
	@GetMapping(path="hello")
	public String hello() {
		return connProp.getUrl()+" : "+ connProp.getPassword();
	}
}
