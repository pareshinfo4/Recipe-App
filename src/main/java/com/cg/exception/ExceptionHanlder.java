package com.cg.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * All custom Exceptions will be handled in ExceptionHandler class
 * 
 * @author parebhar
 *
 */
@ControllerAdvice
public class ExceptionHanlder {
	
	/**
	 * Returns Custom Exception message,current date & time along with status when a recipe is not
	 * found
	 * 
	 * @param exception - exception message
	 * @return - custom exception message along with status NOT_FOUND
	 */
	@ExceptionHandler(RecipeNotFoundException.class)
	public ResponseEntity<Object> recipeNotFound(RecipeNotFoundException exception) {
		ErrorResponse error = new ErrorResponse("No Recipe Found in Database", LocalDateTime.now(),
				HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
