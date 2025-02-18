package com.microservices.userservice.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        super("Resource not found server !!");
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
