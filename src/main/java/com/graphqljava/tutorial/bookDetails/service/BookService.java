package com.graphqljava.tutorial.bookDetails.service;

import java.util.List;
import java.util.Optional;

import com.graphqljava.tutorial.bookDetails.entity.Book;

public interface BookService {

	Book create(Book book);

	List<Book> getAll();

	Book get(Long bookId);

}
