package com.springboot.upworkproject.virusrestapi.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	/**
	* Returns plain Hello World Text. 
	*
	* @return      String
	*/
	@RequestMapping("/hello")
	public String sayHello() {
		return "HelloWorld";
	}

}
