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
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}/books")
    public ResponseEntity<List<Book>> getAllBooks(@PathVariable Long userId) throws UnauthorizedException {

        List<Book> books = userService.getAllBooks(userId);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/{userId}/books")
    public ResponseEntity<String> saveBook(@PathVariable Long userId,
                                           @RequestBody BookRequestDto bookRequestDto) throws UnauthorizedException {

        userService.registerBook(userId,bookRequestDto);
        return ResponseEntity.ok("Book registered");
    }


}
