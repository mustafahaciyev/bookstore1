package com.example.bookstore.service;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.UnauthorizedException;

import java.util.List;

public interface UserService {


    List<Book> getAllBooks(Long userId) throws UnauthorizedException;

    void registerBook(Long bookId, BookRequestDto bookRequestDto) throws UnauthorizedException;


}
