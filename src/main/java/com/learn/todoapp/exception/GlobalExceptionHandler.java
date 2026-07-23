package com.learn.todoapp.exception;

import com.learn.todoapp.utils.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex){
        ErrorResponse error =new  ErrorResponse(
                ex.getMessage(),
                LocalDateTime.now(),
                "Not Found",null);
        return  ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(error);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error ->
                        errors.put(error.getField(), error.getDefaultMessage()));
        ErrorResponse error =new  ErrorResponse(
                "Validation Failed",
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),errors);
        return  ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
