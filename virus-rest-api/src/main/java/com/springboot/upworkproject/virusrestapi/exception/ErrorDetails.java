package com.springboot.upworkproject.virusrestapi.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorDetails {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timestamp;
	private String title;
	private HttpStatus status;
	private String path;
	private String message;
	
	private ErrorDetails() {
		super();
       timestamp = LocalDateTime.now();
   }
	
	public ErrorDetails(String title, String path, String message) {
		this();
		this.title = title;
		this.path = path;
		this.message = message;
	}
	
	public ErrorDetails( String title, HttpStatus status, String path, String message) {
		this();
		this.title = title;
		this.status = status;
		this.path = path;
		this.message = message;
	}
	
	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
