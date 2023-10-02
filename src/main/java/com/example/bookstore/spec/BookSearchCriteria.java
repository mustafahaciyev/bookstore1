package com.example.bookstore.spec;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class BookSearchCriteria {

    private String bookName;
    private String title;
    private String categories;
    private String bookYear;
    private Long authorId;
}

