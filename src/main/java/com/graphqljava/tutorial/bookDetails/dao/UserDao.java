package com.graphqljava.tutorial.bookDetails.dao;

import com.graphqljava.tutorial.bookDetails.entity.MyUser;

public interface UserDao {

	MyUser signupUser(MyUser myUser);
	
	MyUser findByEmail(String email);
}
