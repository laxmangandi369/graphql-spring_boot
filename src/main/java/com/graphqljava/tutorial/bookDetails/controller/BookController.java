package com.graphqljava.tutorial.bookDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.entity.Author;
import com.graphqljava.tutorial.bookDetails.entity.Book;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;
import com.graphqljava.tutorial.bookDetails.service.BookService;


@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	@Autowired
	private AuthorService authorService;

	@MutationMapping("createBook")
	public ResponseEntity<Book> create(@Argument String name, @Argument String description, @Argument int authorId,
			@Argument Float price, @Argument int pages) {
		Author author = authorService.getById(Long.valueOf(authorId));
		Book book = new Book(name, description, author, price, pages);
		return new ResponseEntity<>(bookService.create(book), HttpStatusCode.valueOf(200));
	}

	@QueryMapping("allBooks")
	public List<Book> getAll() {
		return bookService.getAll();
	}

	@Secured({"USER"})
	@QueryMapping("bookById")
	public Book bookById(@Argument Long id) {
		return bookService.get(id);
	}

}
