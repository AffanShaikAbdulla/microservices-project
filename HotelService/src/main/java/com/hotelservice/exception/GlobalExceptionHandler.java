package com.hotelservice.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {
	public ResponseEntity<Map<String, Object>> notFoundHandler(ResourceNotFoundException ex){
		Map map = new HashMap<>();
		map.put("message",ex.getMessage());
		map.put("sucess", false);
		map.put("status", HttpStatus.NOT_FOUND);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	
	}

}
