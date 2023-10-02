package com.example.bookstore.service;

import com.example.bookstore.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(Long id);

    List<Book> findBooksByCriteria(String bookName, String title, String categories, String bookYear, Long authorId);
}
