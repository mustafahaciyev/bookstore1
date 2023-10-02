package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.entity.Book;
import com.example.bookstore.repo.BookRepository;
import com.example.bookstore.service.BookService;
import com.example.bookstore.spec.BookSearchCriteria;
import com.example.bookstore.spec.BookSpecificationBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AppConfig appConfig;


    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public List<Book> findBooksByCriteria(String bookName, String title, String categories, String bookYear, Long authorId) {
        BookSearchCriteria criteria = new BookSearchCriteria();
        criteria.setBookName(bookName);
        criteria.setTitle(title);
        criteria.setCategories(categories);
        criteria.setBookYear(bookYear);
        criteria.setAuthorId(authorId);

        Specification<Book> spec = BookSpecificationBuilder.buildSpecification(criteria);

        return bookRepository.findAll(spec);
    }
}
