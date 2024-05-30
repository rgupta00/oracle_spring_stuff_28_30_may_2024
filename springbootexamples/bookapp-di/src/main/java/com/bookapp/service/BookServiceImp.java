package com.bookapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.persistance.Book;
import com.bookapp.persistance.BookDao;
import com.bookapp.persistance.BookDaoImp;
@Service(value = "bookService")
public  class BookServiceImp implements BookService {

	//@Autowired can be applied at field injection , setter injection, constructor injection
	private BookDao dao;
	
	@Autowired
	public void setDao(BookDao dao) {
		this.dao = dao;
	}

	@Override
	public List<Book> getAllBooks() {
		return dao.getAllBooks();
	}

	@Override
	public Book addBook(Book book) {
		return dao.addBook(book);
	}

	@Override
	public void deleteBook(int id) {
		dao.deleteBook(id);
	}

	@Override
	public void updateBook(int id, Book book) {
		dao.updateBook(id, book);
	}

	@Override
	public Book getBookById(int id) {
		return dao.getBookById(id);
	}

}