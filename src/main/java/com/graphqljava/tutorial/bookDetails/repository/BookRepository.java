package com.graphqljava.tutorial.bookDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.graphqljava.tutorial.bookDetails.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{

}
