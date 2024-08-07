package com.smartpay.exception;

import org.apache.http.HttpStatus;

public class UserRegistrationException extends RuntimeException {
	
	private HttpStatus httpStatus;

	public UserRegistrationException(String message) {
		super(message);

	}

	public UserRegistrationException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public UserRegistrationException(HttpStatus httpStatus) {
		super();
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
	
	
	

}
