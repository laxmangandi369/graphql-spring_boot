package com.graphqljava.tutorial.bookDetails.service;

import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.dao.BookDao;
import com.graphqljava.tutorial.bookDetails.entity.Book;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
//import com.graphqljava.tutorial.bookDetails.exception.CustomGraphQLErrorHandler;
//import com.graphqljava.tutorial.bookDetails.exception.CustomGraphQLException;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book create(Book book) {
		return bookDao.create(book);
	}

	@Override
	public List<Book> getAll() {
		List<Book> books = bookDao.getAll();
		if(books.isEmpty()) {
			throw new CustomException("no data available.");
		}
		return books;
	}

	@Override
	public Book get(Long bookId) {
//		try {
//			return bookDao.get(bookId);
//		} catch (Exception e) {
//			throw new CustomGraphQLException("bookId "+bookId+" not found",404,false);
//		}
		try {
			return bookDao.get(bookId);
		} catch (Exception e) {
			throw new CustomException("bookId "+bookId+" not found");
		}
	}

}
