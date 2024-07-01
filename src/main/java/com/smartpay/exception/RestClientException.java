package com.smartpay.exception;

import org.springframework.web.client.HttpStatusCodeException;

public class RestClientException extends RuntimeException{
	
	private HttpStatusCodeException httpStatusCodeException;

	public RestClientException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RestClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RestClientException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RestClientException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RestClientException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public RestClientException(HttpStatusCodeException httpStatusCodeException) {
		this.httpStatusCodeException = httpStatusCodeException;
	}

	public HttpStatusCodeException getHttpStatusCodeException() {
		return httpStatusCodeException;
	}

	public void setHttpStatusCodeException(HttpStatusCodeException httpStatusCodeException) {
		this.httpStatusCodeException = httpStatusCodeException;
	}
	
	
	
	

}
