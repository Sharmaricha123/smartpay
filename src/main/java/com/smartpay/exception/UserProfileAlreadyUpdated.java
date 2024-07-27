package com.smartpay.exception;

import org.apache.http.HttpStatus;

public class UserProfileAlreadyUpdated extends RuntimeException {
	
	private HttpStatus httpStatus;

	public UserProfileAlreadyUpdated() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserProfileAlreadyUpdated(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserProfileAlreadyUpdated(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserProfileAlreadyUpdated(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserProfileAlreadyUpdated(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	

	public UserProfileAlreadyUpdated(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

	
	
	
	
	
	

}
