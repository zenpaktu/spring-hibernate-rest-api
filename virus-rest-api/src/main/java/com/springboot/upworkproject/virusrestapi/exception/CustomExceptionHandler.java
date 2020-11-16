package com.springboot.upworkproject.virusrestapi.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.WebRequest;


public abstract class CustomExceptionHandler {

	/**
	* Handle Data Not Found Exceptions
	*
	* @param	exception DataNotFoundException
	* @param	request WebRequest
	* @return   ResponseEntity 
	*/
	public abstract ResponseEntity<?> handleDataNotFoundException(DataNotFoundException exception, WebRequest request);
	
	/**
	* Handle Invalid Argument Exceptions
	*
	* @param	exception IllegalArgumentException
	* @param	request WebRequest
	* @return   ResponseEntity 
	*/
	public abstract ResponseEntity<?> handleInvalidArgumentException(IllegalArgumentException exception, WebRequest request);

	
	/**
	* Handle unexpected errors and declare them as internal server errors
	*
	* @param	exception Exception
	* @param	request WebRequest
	* @return   ResponseEntity 
	*/
	public abstract ResponseEntity<?> handleGeneralExceptionHandling(Exception exception, WebRequest request);

}
