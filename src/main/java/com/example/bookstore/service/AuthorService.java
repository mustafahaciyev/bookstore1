package com.example.bookstore.service;

import com.example.bookstore.dto.AuthorAddedBooksDto;
import com.example.bookstore.dto.AuthorRegisterRequestDto;
import com.example.bookstore.entity.Author;

public interface AuthorService {
    void registerAuthor(AuthorRegisterRequestDto authorRegisterRequestDto);

//    String authorAddedBooks(AuthorAddedBooksDto authorAddedBooksDto);
}
