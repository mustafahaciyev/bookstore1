package com.example.bookstore.exception;

public class LoginFailedException extends Exception{
    public LoginFailedException(String message){
         super(message);
    }
}
