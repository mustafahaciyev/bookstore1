package com.example.bookstore.service;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);
}
