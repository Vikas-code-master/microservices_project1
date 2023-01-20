package com.vg.userservices.exception;

import com.vg.userservices.payload.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
        String msg = ex.getMessage();
        ApiResponse apiResponse = ApiResponse.builder().message(msg).success(true).status(HttpStatus.NOT_FOUND).build();
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
