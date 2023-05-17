package com.example.BookManager.controller;

import com.example.BookManager.exception.AuthorNotFoundException;
import com.example.BookManager.exception.BookNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // handle exceptions globally across all controllers in the application.
public class GlobalExceptionHandler {
    @ExceptionHandler({AuthorNotFoundException.class, IllegalArgumentException.class,
            BookNotFoundException.class}) // exceptions that will returnNotFoundException method handle

    public ResponseEntity<Object> returnNotFoundException(Exception ex) {

        if(ex instanceof AuthorNotFoundException) { //if author not found
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

        } else if(ex instanceof BookNotFoundException) { //if book not found
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);

        } else { //anything else exception
            return new ResponseEntity<>(ex.getMessage(),
                    HttpStatus.BAD_REQUEST);
        }
    }
}
