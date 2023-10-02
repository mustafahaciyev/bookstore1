package com.example.bookstore.controller;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Book;
import com.example.bookstore.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;


    @GetMapping
    public List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id){
       return bookService.getBookById(id);

    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam(value = "bookName", required = false) String bookName,
                                  @RequestParam(value = "title", required = false) String title,
                                  @RequestParam(value = "categories", required = false) String categories,
                                  @RequestParam(value = "bookYear", required = false) String bookYear,
                                  @RequestParam(value = "authorId", required = false) Long authorId) {
        return bookService.findBooksByCriteria(bookName, title, categories, bookYear, authorId);
    }







}
