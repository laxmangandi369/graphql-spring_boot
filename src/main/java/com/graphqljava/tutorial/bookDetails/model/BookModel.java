package com.graphqljava.tutorial.bookDetails.model;


import lombok.Data;

@Data
public class BookModel {

	private String name;
	private String description;
	private int authorId;
	private float price;
	private int pages;
}
