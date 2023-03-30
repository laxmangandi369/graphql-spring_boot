package com.graphqljava.tutorial.bookDetails.exception;

import org.springframework.http.HttpStatus;

public class CustomException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CustomException(String message) {
		super(message);
	}	
}
