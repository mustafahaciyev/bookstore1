package com.example.bookstore.controller;


import com.example.bookstore.dto.AuthorAddedBooksDto;
import com.example.bookstore.dto.AuthorRegisterRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody AuthorRegisterRequestDto authorRegisterRequestDto){
        authorService.registerAuthor(authorRegisterRequestDto);
        return ResponseEntity.ok("Author registered successfully.");
    }

//    @PostMapping("/added-book")
//    public String authorAddedBooks(@RequestBody AuthorAddedBooksDto authorAddedBooksDto){
//         authorService.authorAddedBooks(authorAddedBooksDto);
//         return "Book added successfully";
//    }


}
