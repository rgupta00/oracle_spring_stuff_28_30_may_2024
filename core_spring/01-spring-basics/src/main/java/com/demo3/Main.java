package com.demo3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext ctx=new ClassPathXmlApplicationContext("demo3.xml");
		ctx.registerShutdownHook();
		
		
		Foo f=(Foo) ctx.getBean("foo");
		
		f.print();
		
	}
}
