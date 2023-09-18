package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.config.UserMapper;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.LoginRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.entity.User;
import com.example.bookstore.exception.UnauthorizedException;
import com.example.bookstore.repo.BookRepository;
import com.example.bookstore.repo.UserRepository;
import com.example.bookstore.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final AppConfig appConfig;
    private final UserMapper userMapper;


    @Override
    public void registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        User user = new User();
        user.setName(userRegisterRequestDto.getName());
        user.setSurname(userRegisterRequestDto.getSurname());
        user.setEmail(userRegisterRequestDto.getEmail());
        // Hash and set the password
        user.setPassword(userRegisterRequestDto.getPassword());
        user.setActive(false);
        userRepository.save(user);
    }

    @Override
    public List<Book> getAllBooks(Long userId) throws UnauthorizedException {
        boolean isUserActive = isUserActive(userId);
        if (!isUserActive) {
            throw new UnauthorizedException("You must log in and have an active account to save books.");
        }
       User user = userRepository.findById(userId)
               .orElseThrow(() -> new EntityNotFoundException("User not found"));
       return user.getBooks();
    }

    @Override
    public void registerBook(Long userId, BookRequestDto bookRequestDto) throws UnauthorizedException {

        boolean isUserActive = isUserActive(userId);
        if (!isUserActive) {
            throw new UnauthorizedException("You must log in and have an active account to save books.");
        }
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        Book existingBook = bookRepository.findByTitle(bookRequestDto.getTitle());

        if (existingBook == null) {

            Book newBook = new Book();
            newBook.setTitle(bookRequestDto.getTitle());
            newBook.getUsers().add(user);
            user.getBooks().add(newBook);

            userRepository.save(user);
            bookRepository.save(newBook);
        } else {

            existingBook.getUsers().add(user);
            user.getBooks().add(existingBook);

            userRepository.save(user);

    }
    }

    @Override
    public boolean isUserActive(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        return user.isActive();
    }


}
