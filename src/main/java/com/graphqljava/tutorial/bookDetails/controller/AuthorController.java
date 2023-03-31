package com.graphqljava.tutorial.bookDetails.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.entity.Author;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@QueryMapping("authorById")
	public Author authorById(@Argument Long id){
//		return new ResponseEntity<>(authorService.getById(id),HttpStatus.OK);
		return authorService.getById(id);
	}

}
