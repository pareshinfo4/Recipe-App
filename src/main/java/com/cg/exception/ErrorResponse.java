package com.cg.exception;

import java.time.LocalDateTime;

/**
 * This class for API ExceptionResponse data members
 * @author parebhar
 *
 */
public class ErrorResponse {

	private String message;
	private LocalDateTime timestamp;
	private int statusCode;

    public ErrorResponse() {
		super();
		
	}

	/**
	 * @param message
	 * @param timestamp
	 */
    public ErrorResponse(String message, LocalDateTime timestamp, int statusCode) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
    
    
}
