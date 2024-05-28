package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainWithSpring {
	
	public static void main(String[] args) {
	
		//ClassPathXmlApplicationContext: xml+ annotation
		//AnnotationConfigApplicationContext: if u are using annotation + java config
		ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		
		Passanger passanger=(Passanger) ctx.getBean("passanger");
		passanger.travel();

		
	}

}
