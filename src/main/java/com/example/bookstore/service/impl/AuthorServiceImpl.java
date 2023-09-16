package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.config.AuthorMapper;
import com.example.bookstore.dto.AuthorRegisterRequestDto;
import com.example.bookstore.entity.Author;
import com.example.bookstore.repo.AuthorRepository;
import com.example.bookstore.repo.BookRepository;
import com.example.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AppConfig appConfig;
    private final AuthorMapper authorMapper;


    @Override
    public void registerAuthor(AuthorRegisterRequestDto authorRegisterRequestDto) {

        Author author = new Author();
        author.setName(authorRegisterRequestDto.getName());
        author.setSurname(authorRegisterRequestDto.getSurname());
        author.setPassword(authorRegisterRequestDto.getPassword());
        author.setEmail(authorRegisterRequestDto.getEmail());
        author.setActive(false);
        authorRepository.save(author);
    }

//    @Override
//    public String authorAddedBooks(AuthorAddedBooksDto authorAddedBooksDto) {
//        Book book = appConfig.getMapper().map(authorAddedBooksDto, Book.class);
//
//
//
//         return bookRepository.save(book) + "finee";
//
//
//    }
}
