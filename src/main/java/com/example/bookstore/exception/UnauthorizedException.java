package com.example.bookstore.exception;

public class UnauthorizedException extends Throwable {
    public UnauthorizedException(String message) {
        super(message);
    }
}
