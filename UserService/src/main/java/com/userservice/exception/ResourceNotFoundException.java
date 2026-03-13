package com.userservice.exception;

import lombok.experimental.SuperBuilder;

public class ResourceNotFoundException extends RuntimeException{
// 1.ResourceNOTFOUND,
 public ResourceNotFoundException() {
	 super("Resource not found on server");
	 
 }
 public ResourceNotFoundException(String message) {
	 super(message);
 }
}
