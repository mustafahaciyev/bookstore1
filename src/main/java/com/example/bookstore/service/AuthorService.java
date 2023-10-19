package com.example.bookstore.service;

import com.example.bookstore.dto.AuthorRegisterRequestDto;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.UnauthorizedException;

import java.nio.file.AccessDeniedException;
import java.util.List;

public interface AuthorService {
//    void registerAuthor(AuthorRegisterRequestDto authorRegisterRequestDto);

    void saveBook(Long authorId, BookRequestDto bookRequestDto) throws UnauthorizedException;

    void updateBook(Long authorId, Long bookId, BookRequestDto bookRequestDto) throws AccessDeniedException, UnauthorizedException;

    void deleteBook(Long authorId, Long bookId) throws AccessDeniedException, UnauthorizedException;

    List<Book> getAllBooks(Long authorId) throws UnauthorizedException;

//    boolean isAuthorActive(Long authorId);

}
