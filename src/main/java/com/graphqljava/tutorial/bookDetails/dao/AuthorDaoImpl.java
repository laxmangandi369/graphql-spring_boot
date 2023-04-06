package com.graphqljava.tutorial.bookDetails.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.Author;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
import com.graphqljava.tutorial.bookDetails.repository.AuthorRepository;

@Repository
public class AuthorDaoImpl implements AuthorDao{

	@Autowired
	private AuthorRepository authorRepository;
	
	@Override
	public Author getById(Long id) {
		Author author = authorRepository.findById(id).get();
		try {
			return authorRepository.findById(id).get();
		} catch (Exception e) {
			throw new CustomException("author with "+id+" not found.");
		}
	}
	
	@Override
	public Author saveAUthor(Author author) {
		if(author !=null) {
			return authorRepository.save(author);
		}
		else {
			throw new CustomException("cannot save the author with autherId "+author.getId());
		}
	}

}
