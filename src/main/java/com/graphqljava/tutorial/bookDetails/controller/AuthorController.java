package com.graphqljava.tutorial.bookDetails.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;

import com.graphqljava.tutorial.bookDetails.entity.Author;
import com.graphqljava.tutorial.bookDetails.entity.DataTest;
import com.graphqljava.tutorial.bookDetails.service.AuthorService;

@Controller
public class AuthorController {
	
	@Autowired
	private AuthorService authorService;
	
	@PreAuthorize("hasRole('USER')")
	@QueryMapping("authorById")
	public Author authorById(@Argument Long id){
//		return new ResponseEntity<>(authorService.getById(id),HttpStatus.OK);
		return authorService.getById(id);
	}
	@MutationMapping("saveAuthor")
	public Author saveAuthor(@Argument String name, @Argument String testDataString) {
		List<DataTest> dataTests = new ArrayList<>();
		dataTests.add(new DataTest(testDataString));
		Author author = new Author(name,dataTests);
		
		return authorService.saveAuthor(author);
	}

}
