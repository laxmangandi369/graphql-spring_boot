package com.graphqljava.tutorial.bookDetails.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.Book;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
import com.graphqljava.tutorial.bookDetails.repository.BookRepository;

@Repository
public class BookDaoImpl implements BookDao{

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public Book create(Book book) {
		return bookRepository.save(book);		
	}

	@Override
	public List<Book> getAll() {
		try {
			return bookRepository.findAll();
		} catch (Exception e) {
			throw new CustomException("no books available to view");
		}
	}

	@Override
	public Book get(Long bookId){
		try {
			return bookRepository.findById(bookId).get();
		} catch (Exception e) {
			throw new CustomException("bookId "+bookId+" not found.");
		}

		
	}

}
