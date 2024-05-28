package com.bookapp.controller;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bookapp.persistance.Book;
import com.bookapp.service.BookService;
import com.bookapp.service.BookServiceImp;

public class Main {

	public static void main(String[] args) {
//		BookService bookService=new BookServiceImp();
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");
		BookService bookService=(BookService) ctx.getBean("bookService");
		List<Book> books=bookService.getAllBooks();
		
		for(Book b: books) {
			System.out.println(b);
		}
	}
}
