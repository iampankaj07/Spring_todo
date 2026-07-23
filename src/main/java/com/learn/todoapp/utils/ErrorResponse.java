package com.learn.todoapp.utils;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ErrorResponse {
    private  final String message;
    private  final LocalDateTime timestamp;
    private  final  String error;

}
