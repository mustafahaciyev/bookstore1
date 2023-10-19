package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.UnauthorizedException;
import com.example.bookstore.repo.AuthorRepository;
import com.example.bookstore.repo.BookRepository;
import com.example.bookstore.service.AuthorService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.file.AccessDeniedException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final AppConfig appConfig;


//    @Override
//    public void registerAuthor(AuthorRegisterRequestDto authorRegisterRequestDto) {
//
//        Author author = new Author();
//        author.setName(authorRegisterRequestDto.getName());
//        author.setSurname(authorRegisterRequestDto.getSurname());
//        author.setPassword(authorRegisterRequestDto.getPassword());
//        author.setEmail(authorRegisterRequestDto.getEmail());
//        author.setActive(false);
//        authorRepository.save(author);
//    }

    @Override
    public void saveBook(Long authorId, BookRequestDto bookRequestDto) throws UnauthorizedException {


        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));


        Book book = appConfig.getMapper().map(bookRequestDto, Book.class);

        book.setAuthor(author);

        bookRepository.save(book);

    }

    @Override
    public void updateBook(Long authorId, Long bookId, BookRequestDto bookRequestDto) throws AccessDeniedException, UnauthorizedException {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (!book.getAuthor().getId().equals(author.getId())) {
            throw new AccessDeniedException("You do not have permission to update this book.");
        }

        book.setTitle(bookRequestDto.getTitle());
        bookRepository.save(book);


    }

    @Override
    public void deleteBook(Long authorId, Long bookId) throws AccessDeniedException, UnauthorizedException {


        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (!book.getAuthor().getId().equals(author.getId())) {
            throw new AccessDeniedException("You do not have permission to update this book.");
        }

        author.getBooks().remove(book);
        authorRepository.save(author);

        bookRepository.delete(book);


    }

    @Override
    public List<Book> getAllBooks(Long authorId) throws UnauthorizedException {

        Author author = authorRepository.findById(authorId)
                .orElseThrow(() -> new EntityNotFoundException("Author not found"));

        return author.getBooks();


    }


}
