package com.demo2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("demo2.xml");
		School school=(School) ctx.getBean("school");
		school.printDetails();
	}
}
