package com.example.bookstore.repo;

import com.example.bookstore.dto.BookRequestDto;
import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {



}
