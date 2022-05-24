package com.example.expenses.Exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;



public class ResourceNotFoundException extends RuntimeException {

	

	/**
	 * 
	 */
	

	public ResourceNotFoundException(String message) {
		super(message);
	
	}

	

}
