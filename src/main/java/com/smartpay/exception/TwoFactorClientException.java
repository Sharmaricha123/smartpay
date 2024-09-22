package com.smartpay.exception;

import org.springframework.web.client.HttpStatusCodeException;

public class TwoFactorClientException extends RuntimeException {
	
	private HttpStatusCodeException httpStatusCodeException;

	public TwoFactorClientException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TwoFactorClientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TwoFactorClientException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TwoFactorClientException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TwoFactorClientException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
	

	public TwoFactorClientException(HttpStatusCodeException httpStatusCodeException) {
		super();
		this.httpStatusCodeException = httpStatusCodeException;
	}

	public HttpStatusCodeException getHttpStatusCodeException() {
		return httpStatusCodeException;
	}

	public void setHttpStatusCodeException(HttpStatusCodeException httpStatusCodeException) {
		this.httpStatusCodeException = httpStatusCodeException;
	}
	
	
	
	

}
