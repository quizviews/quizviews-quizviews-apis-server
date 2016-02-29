package com.viewquiz.backend.app.quiz.web.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
 
	public ResourceNotFoundException() {}
	
	public ResourceNotFoundException(int id) {
		super("Tis id: " + id + " is not found!");
	}


	public ResourceNotFoundException(String message) {
		super(message);
	}
	public ResourceNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
