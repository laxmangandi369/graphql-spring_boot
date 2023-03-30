package com.graphqljava.tutorial.bookDetails.dao;

import java.util.List;

import com.graphqljava.tutorial.bookDetails.entity.Book;

public interface BookDao {

	Book create(Book book);
	
	List<Book> getAll();
	
	Book get(Long bookId);
}
