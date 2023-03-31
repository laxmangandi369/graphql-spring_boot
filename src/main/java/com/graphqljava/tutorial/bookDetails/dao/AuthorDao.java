package com.graphqljava.tutorial.bookDetails.dao;

import com.graphqljava.tutorial.bookDetails.entity.Author;

public interface AuthorDao {
	
	Author getById(Long id);

}
