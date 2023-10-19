package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.User;
import com.example.bookstore.exception.UnauthorizedException;
import com.example.bookstore.repo.BookRepository;
import com.example.bookstore.repo.UserRepository;
import com.example.bookstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final AppConfig appConfig;



    @Override
    public List<Book> getAllBooks(Long userId) throws UnauthorizedException {

       User user = userRepository.findById(userId)
               .orElseThrow(() -> new EntityNotFoundException("User not found"));
       return user.getBooks();
    }

    @Override
    public void registerBook(Long userId, BookRequestDto bookRequestDto) throws UnauthorizedException {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        List<Book> existingBooks = bookRepository.findByTitle(bookRequestDto.getTitle());

        try {

            if (existingBooks == null) {

                Book newBook = new Book();
                newBook.setBookName(bookRequestDto.getBookName());
                newBook.getUsers().add(user);
                user.getBooks().add(newBook);

                userRepository.save(user);
                bookRepository.save(newBook);
            } else {

                Book existingBook = existingBooks.get(0);
                existingBook.getUsers().add(user);
                user.getBooks().add(existingBook);

                userRepository.save(user);

            }
        } catch (Exception e){
            throw new RuntimeException("Failed");
        }
    }



}
