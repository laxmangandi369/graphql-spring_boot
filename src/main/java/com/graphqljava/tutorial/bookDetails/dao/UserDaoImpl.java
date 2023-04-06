package com.graphqljava.tutorial.bookDetails.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.MyUser;
import com.graphqljava.tutorial.bookDetails.exception.CustomException;
import com.graphqljava.tutorial.bookDetails.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public MyUser signupUser(MyUser myUser) {
		try {
			return userRepository.save(myUser);
		} catch (Exception e) {
			throw new CustomException("error while saving in the databse");
		}
	}

	@Override
	public MyUser findByEmail(String email) {
		MyUser user =userRepository.findByEmail(email);
		
		if(user!=null) {
			return user;
		}
		return null;
	}

	
}
