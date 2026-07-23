package com.learn.todoapp.exception;

import com.learn.todoapp.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(RuntimeException ex){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new  ErrorResponse(ex.getMessage(), LocalDateTime.now(),"Not Found"));
    }
}
