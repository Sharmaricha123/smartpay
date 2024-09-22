package com.smartpay.exception;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smartpay.response.TwoFactorResponse;

import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
public class SmartPayExceptionHandle extends ResponseEntityExceptionHandler {
	
	@Autowired
	private ObjectMapper objectMapper;

	@ExceptionHandler(value= {Exception.class})
	public ResponseEntity<ExceptionResponse> handleAnyException(Exception ex)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR, false,
				ex.getMessage(), null);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(value = { SmartPayGlobalException.class })
	public ResponseEntity<ExceptionResponse> handleGlobalException(SmartPayGlobalException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getHttpStatus(), false,
				ex.getMessage(), null);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getHttpStatus());
	}
	
	@ExceptionHandler(value = { ResourceNotFoundException.class })
	public ResponseEntity<ExceptionResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), HttpStatus.NOT_FOUND, false,
				ex.getMessage(), null);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	
	
	@ExceptionHandler(value = { BadCredentialsException.class })
	public ResponseEntity<ExceptionResponse> BadCredentialsException(SmartPayGlobalException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(LocalDateTime.now(), ex.getHttpStatus(), false,
				ex.getMessage(), null);
		return new ResponseEntity<ExceptionResponse>(exceptionResponse, ex.getHttpStatus());
	}
	
	@ExceptionHandler(value= {TwoFactorClientException.class})
	public ResponseEntity<ExceptionResponse> handleRestClient(TwoFactorClientException ex) throws JsonMappingException, JsonProcessingException
	{
		ExceptionResponse exceptionResponse=new ExceptionResponse();
		if(ex.getHttpStatusCodeException() instanceof HttpClientErrorException|ex.getHttpStatusCodeException() instanceof HttpServerErrorException)
		{
			
			TwoFactorResponse twoFactorResponse=new TwoFactorResponse();
			String response=ex.getHttpStatusCodeException().getResponseBodyAsString();
			twoFactorResponse=	objectMapper.readValue(response, TwoFactorResponse.class);
			exceptionResponse.setDatasource(twoFactorResponse);
			exceptionResponse.setMessage(ex.getMessage());
			exceptionResponse.setProcessStatus(false);
			exceptionResponse.setStatusCode(HttpStatus.SERVICE_UNAVAILABLE);
			exceptionResponse.setTimestamp(LocalDateTime.now());
		}
		return new ResponseEntity<ExceptionResponse>(exceptionResponse,HttpStatus.SERVICE_UNAVAILABLE);
		
	}

}
