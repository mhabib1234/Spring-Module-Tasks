package com.example.BookManager.exception;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message){super(message);}
}
