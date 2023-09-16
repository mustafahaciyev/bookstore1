package com.example.bookstore.dto;

import com.example.bookstore.entity.Author;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorAddedBooksDto {

    String authorName;
    String bookName;
    String bookYear;
    String bookTitle;
    String bookType;

}
