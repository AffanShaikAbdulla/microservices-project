package com.userservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.userservice.payload.ApiResonse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResonse> handleResourceNotFoundException(ResourceNotFoundException ex){
	String msg=ex.getMessage();
	//builderpattern -building object
	ApiResonse response=ApiResonse.builder().message(msg).sucess(true).status(HttpStatus.NOT_FOUND).build();
	return new ResponseEntity<ApiResonse>(response,HttpStatus.NOT_FOUND);
	}

}
