package com.example.bookstore.controller;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.UnauthorizedException;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody UserRegisterRequestDto userDto) {
        userService.registerUser(userDto);
        return ResponseEntity.ok("User registered successfully.");
    }

    @GetMapping("/{userId}/books")
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable Long userId) throws UnauthorizedException {
        boolean isUserActive = userService.isUserActive(userId);
        if (!isUserActive) {
             ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must log in and have an active account to save books.");
        }
        List<Book> books = userService.getAllBooks(userId);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/{userId}/books")
    public ResponseEntity<String> saveBook(@PathVariable Long userId,
                                           @RequestBody BookRequestDto bookRequestDto) throws UnauthorizedException {
        boolean isUserActive = userService.isUserActive(userId);
        if (!isUserActive) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must log in and have an active account to save books.");
        }
        userService.registerBook(userId,bookRequestDto);
        return ResponseEntity.ok("Book registered");
    }







}
