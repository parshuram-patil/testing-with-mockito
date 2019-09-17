package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<Exception> exceptionHandler(Exception ex) {
		
		return new ResponseEntity<Exception>(ex, HttpStatus.BAD_REQUEST);
	}
}
