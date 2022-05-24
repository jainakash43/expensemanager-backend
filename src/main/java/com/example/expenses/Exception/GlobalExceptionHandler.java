package com.example.expenses.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFound(ResourceNotFoundException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(ResourceConflictException.class)
	public ResponseEntity<String> resourceConflict(ResourceConflictException ex)
	{
		return new ResponseEntity<String>(ex.getMessage(),HttpStatus.CONFLICT);
	}
	
}
