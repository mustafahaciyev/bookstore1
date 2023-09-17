package com.example.bookstore.service;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.LoginRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.User;
import com.example.bookstore.exception.UnauthorizedException;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
//    long saveRegister(UserRegisterRequestDto userRegisterRequestDto);

    

//    void registerUser(UserRegisterRequestDto userRegisterRequestDto);



    void registerUser(UserRegisterRequestDto userRegisterRequestDto);

    List<Book> getAllBooks(Long userId) throws UnauthorizedException;

    void registerBook(Long bookId, BookRequestDto bookRequestDto) throws UnauthorizedException;

    boolean isUserActive(Long userId);
}
