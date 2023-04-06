package com.graphqljava.tutorial.bookDetails.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "author_details")
@Data
public class Author {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	
	@OneToMany
	@JoinColumn(name = "author_id")
	private List<DataTest> dataTest;

	public Author(String name, List<DataTest> dataTest) {
		super();
		this.name = name;
		this.dataTest = dataTest;
	}
	
	


}
