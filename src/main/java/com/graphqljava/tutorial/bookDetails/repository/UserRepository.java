package com.graphqljava.tutorial.bookDetails.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{
	
	MyUser findByEmail(String email);
	
	List<MyUser> findByRoles(String role);

}
