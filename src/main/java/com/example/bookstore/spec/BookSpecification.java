package com.example.bookstore.spec;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.domain.Specification;

public class BookSpecification {

    public static Specification<Book> hasBookName(String bookName) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bookName"), bookName);
    }

    public static Specification<Book> hasTitle(String title) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("title"), title);
    }

    public static Specification<Book> hasCategories(String categories) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("categories"), categories);
    }

    public static Specification<Book> hasBookYear(String bookYear) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("bookYear"), bookYear);
    }

    public static Specification<Book> hasAuthor(Author author) {
        return (root, query, criteriaBuilder) ->
                criteriaBuilder.equal(root.get("author"), author);
    }
}

