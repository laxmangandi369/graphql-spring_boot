package com.graphqljava.tutorial.bookDetails.service;

import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.entity.Author;

public interface AuthorService {

	Author getById(Long id);
}
