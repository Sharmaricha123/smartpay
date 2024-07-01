package com.smartpay.exception;

import org.springframework.http.HttpStatus;

public class BadCredentialsException extends RuntimeException {

	private String message;
	private HttpStatus httpStatus;
	public BadCredentialsException() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BadCredentialsException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}
	public BadCredentialsException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	public BadCredentialsException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	public BadCredentialsException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	public BadCredentialsException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}
	
	
}
