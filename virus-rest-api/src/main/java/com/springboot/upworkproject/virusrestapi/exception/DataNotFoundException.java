package com.springboot.upworkproject.virusrestapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class DataNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	private String beantype;

	public DataNotFoundException(String message) {
		super(message);
	}
	
	public DataNotFoundException(String attributeName, String value, String beantype) {
		super("Data with the "+ attributeName + " of " + value + " does not exist.");
		this.beantype = beantype;
	}

	public String getBeantype() {
		return beantype;
	}

	public void setBeantype(String beantype) {
		this.beantype = beantype;
	}
}
