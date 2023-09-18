package com.example.bookstore.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthorRegisterRequestDto {

    String name;
    String surname;
    String email;
    String password;

}
