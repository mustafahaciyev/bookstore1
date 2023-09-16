package com.example.bookstore.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private boolean isActive;

    @ManyToMany
            @JoinTable(name = "users_book",
            joinColumns = @JoinColumn(name = "users_id"),
           inverseJoinColumns = @JoinColumn(name = "book_id"))
    List<Book> books = new ArrayList<>();
}
