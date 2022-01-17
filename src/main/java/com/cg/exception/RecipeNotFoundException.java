package com.cg.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom Exception details
 * 
 * @author parebhar
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecipeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecipeNotFoundException() {
		super();
	}

	public RecipeNotFoundException(String message) {
		super(message);
	}

	
}
