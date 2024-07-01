package com.smartpay.exception;

import org.springframework.http.HttpStatus;

public class SmartPayGlobalException extends RuntimeException {

//	private String message;
	private HttpStatus httpStatus;

	public SmartPayGlobalException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SmartPayGlobalException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public SmartPayGlobalException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SmartPayGlobalException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SmartPayGlobalException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public SmartPayGlobalException(String message,HttpStatus httpStatus) {
		super(message);
		this.httpStatus = httpStatus;
	}

//	public String getMessage() {
//		return message;
//	}
//
//	public void setMessage(String message) {
//		this.message = message;
//	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}

}
