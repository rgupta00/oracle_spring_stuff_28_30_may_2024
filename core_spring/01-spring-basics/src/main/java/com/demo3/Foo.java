package com.demo3;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Foo {
	private String name;


	public Foo() {
		System.out.println("ctr is called");
	}

	public void setName(String name) {
		System.out.println("set name is called");
		this.name = name;
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("post construct method is called");
	}
	public void print() {
		System.out.println("print method  is called");
		System.out.println("name is : "+ name);
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("pre destroy method is called");
	}
}
