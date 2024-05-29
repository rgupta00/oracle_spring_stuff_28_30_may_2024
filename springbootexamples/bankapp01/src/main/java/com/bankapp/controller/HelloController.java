package com.bankapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

//	@RequestParam
//	@PathVariable
	
	@GetMapping(path="hello/{name}")
	public String helloMethod2(@PathVariable(name="name") String uname) {
		return "hello champ! "+ uname;
	}
	
	@GetMapping(path="hello/{name}/{city}")
	public String helloMethod(@PathVariable(name="name") String uname, @PathVariable String city) {
		return "hello champ! "+ uname+" you are from "+ city;
	}
	
	//http://localhost:8080/myurl?name=raja&city=noida have to use something called @RequestParam
	
	@GetMapping(path="myurl")
	public String hello2(@RequestParam(name="name", required = false) String name, @RequestParam(name="city", required = false) String city) {
		return "hello champ! "+ name+" you are from "+ city;
	}
	
	
}










