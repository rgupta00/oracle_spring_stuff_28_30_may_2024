package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithSpring {
	
	public static void main(String[] args) {
	
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo.xml");
		
		Passanger passanger=(Passanger) ctx.getBean("passanger");
		passanger.travel();

		
	}

}
