package com.vg.userservices.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException() {
        super("resource not found on server");
    }
    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
