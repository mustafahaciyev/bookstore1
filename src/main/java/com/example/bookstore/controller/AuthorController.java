package com.example.bookstore.controller;


import com.example.bookstore.dto.AuthorRegisterRequestDto;
import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.UnauthorizedException;
import com.example.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

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

    @PostMapping("/{authorId}/books")
    public ResponseEntity<String> saveBook(@PathVariable Long authorId,
                                           @RequestBody BookRequestDto bookRequestDto
                                           ) throws UnauthorizedException {
        boolean isAuthorActive = authorService.isAuthorActive(authorId);
        if (!isAuthorActive){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must log in and have an active account to save books.");
        }
            authorService.saveBook(authorId, bookRequestDto);
            return ResponseEntity.ok("Book saved");

    }

    @PutMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable Long authorId,
                                             @PathVariable Long bookId,
                                             @RequestBody BookRequestDto bookRequestDto) throws AccessDeniedException, UnauthorizedException {
        boolean isAuthorActive = authorService.isAuthorActive(authorId);
        if (!isAuthorActive){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must log in and have an active account to save books.");
        }
        authorService.updateBook(authorId,bookId,bookRequestDto);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long authorId, @PathVariable Long bookId) throws AccessDeniedException, UnauthorizedException {
        boolean isAuthorActive = authorService.isAuthorActive(authorId);
        if (!isAuthorActive){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must log in and have an active account to save books.");
        }
        authorService.deleteBook(authorId,bookId);
        return ResponseEntity.ok("Book deleted");
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getALlBooks(@PathVariable Long authorId) throws UnauthorizedException {
        boolean isAuthorActive = authorService.isAuthorActive(authorId);
        if (!isAuthorActive){
             ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("You must log in and have an active account to save books.");
        }
        List<Book> books = authorService.getAllBooks(authorId);
        return ResponseEntity.ok(books);
    }


}
