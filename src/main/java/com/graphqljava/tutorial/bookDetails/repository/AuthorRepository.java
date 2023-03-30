package com.graphqljava.tutorial.bookDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
