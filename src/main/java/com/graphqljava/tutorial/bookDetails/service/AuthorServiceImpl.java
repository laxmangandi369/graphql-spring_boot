package com.graphqljava.tutorial.bookDetails.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphqljava.tutorial.bookDetails.dao.AuthorDao;
import com.graphqljava.tutorial.bookDetails.entity.Author;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDao authorDao;
	
	@Override
	public Author getById(Long id) {
		return authorDao.getById(id);
	}

}
