package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repo.BookRepository;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AppConfig appConfig;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }
}
