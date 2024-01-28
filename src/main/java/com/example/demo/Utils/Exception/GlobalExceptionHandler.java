package com.example.demo.Utils.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String >handleBadRequestException(BadRequestException ex){
        return ResponseEntity.badRequest().body(ex.getMessage());

    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String >handleValidationException(MethodArgumentNotValidException ex){
       return ResponseEntity.badRequest().body("validation error "+ex.getBindingResult().getFieldError().getDefaultMessage());
    }
}
