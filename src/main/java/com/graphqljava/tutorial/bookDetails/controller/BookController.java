package com.graphqljava.tutorial.bookDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;

import com.graphqljava.tutorial.bookDetails.entity.Book;
import com.graphqljava.tutorial.bookDetails.service.BookService;

//@RestController
//@RequestMapping("/test")
@Controller
public class BookController {

	@Autowired
	private BookService bookService;

//	@PostMapping
	@MutationMapping("addBooks")
	public ResponseEntity<Book> create(Book book) {
		return new ResponseEntity<>(bookService.create(book), HttpStatusCode.valueOf(200));
	}
	
//	@GetMapping
	@QueryMapping("allBooks")
	public List<Book> getAll(){
		return bookService.getAll();
	}
//	@GetMapping("/{id}")
	@QueryMapping("bookById")
	public Book bookById(@Argument Long id){
		return bookService.get(id);
	}
}
