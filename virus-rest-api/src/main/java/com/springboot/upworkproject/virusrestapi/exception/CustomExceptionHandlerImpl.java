package com.springboot.upworkproject.virusrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;


@ControllerAdvice
public class CustomExceptionHandlerImpl extends CustomExceptionHandler{
	
	@Override
	@ExceptionHandler(DataNotFoundException.class)
	public ResponseEntity<?> handleDataNotFoundException(DataNotFoundException exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails("Unregistered "+exception.getBeantype(), HttpStatus.NOT_FOUND, request.getDescription(false), exception.getMessage() );
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
	
	@Override
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<?> handleInvalidArgumentException(IllegalArgumentException exception, WebRequest request) {
		ErrorDetails errorDetails = 
				new ErrorDetails("Invalid Argument", HttpStatus.BAD_REQUEST, request.getDescription(false), exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	@Override
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handleGeneralExceptionHandling(Exception exception, WebRequest request){
		ErrorDetails errorDetails = 
				new ErrorDetails("Unexpected Error", HttpStatus.INTERNAL_SERVER_ERROR, request.getDescription(false), exception.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
