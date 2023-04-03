package com.graphqljava.tutorial.bookDetails.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.Book;
//import com.graphqljava.tutorial.bookDetails.exception.CustomGraphQLErrorHandler;
//import com.graphqljava.tutorial.bookDetails.exception.CustomGraphQLException;
import com.graphqljava.tutorial.bookDetails.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book create(Book book) {
			Book book2 =  bookRepository.save(book);
			return book2;
		
	}

	@Override
	public List<Book> getAll() {
//		try {
//			return bookRepository.findAll();
//		} catch (Exception e) {
//			throw new CustomGraphQLException("books not found", false);
//		}
		return bookRepository.findAll();
	}

	@Override
	public Book get(Long bookId){
			return bookRepository.findById(bookId).get();
//					.orElseThrow(() -> new CustomGraphQLException(bookId+" not found",false));

		
	}

}
