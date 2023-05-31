package com.example.demo.controller;

import com.example.demo.entity.StudentErrorResponse;
import com.example.demo.exeption.StudentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exception) {
        return new ResponseEntity<>(
                new StudentErrorResponse(
                        HttpStatus.NOT_FOUND.value(),
                        exception.getMessage(),
                        System.currentTimeMillis()),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exception) {
        return new ResponseEntity<>(
                new StudentErrorResponse(
                        HttpStatus.BAD_REQUEST.value(),
                        exception.getMessage(),
                        System.currentTimeMillis()),
                HttpStatus.BAD_REQUEST);
    }
}
