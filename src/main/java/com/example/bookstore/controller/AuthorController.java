package com.example.bookstore.controller;


import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.exception.UnauthorizedException;
import com.example.bookstore.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.util.List;

@RestController
@RequestMapping("authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;


    @PostMapping("/{authorId}/books")
    public ResponseEntity<String> saveBook(@PathVariable Long authorId,
                                           @RequestBody BookRequestDto bookRequestDto
                                           ) throws UnauthorizedException {

            authorService.saveBook(authorId, bookRequestDto);
            return ResponseEntity.ok("Book saved");

    }

    @PutMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<String> updateBook(@PathVariable Long authorId,
                                             @PathVariable Long bookId,
                                             @RequestBody BookRequestDto bookRequestDto) throws AccessDeniedException, UnauthorizedException {

        authorService.updateBook(authorId,bookId,bookRequestDto);
        return ResponseEntity.ok("Book updated successfully");
    }

    @DeleteMapping("/{authorId}/books/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable Long authorId, @PathVariable Long bookId) throws AccessDeniedException, UnauthorizedException {

        authorService.deleteBook(authorId,bookId);
        return ResponseEntity.ok("Book deleted");
    }

    @GetMapping("/{authorId}/books")
    public ResponseEntity<List<Book>> getALlBooks(@PathVariable Long authorId) throws UnauthorizedException {
        List<Book> books = authorService.getAllBooks(authorId);
        return ResponseEntity.ok(books);
    }


}
