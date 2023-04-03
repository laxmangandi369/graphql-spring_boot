package com.graphqljava.tutorial.bookDetails.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "bookdetails")
@Data
public class Book {
	
	
	
	public Book(String name, String description, Author author, double price, int pages) {
		super();
		this.name = name;
		this.description = description;
		this.author = author;
		this.price = price;
		this.pages = pages;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	
	@Column
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Author author;
	
	@Column
	private double price;
		
	@Column
	private int pages;
}
