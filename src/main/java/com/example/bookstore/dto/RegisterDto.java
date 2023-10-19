package com.example.bookstore.dto;

import com.example.bookstore.entity.UserType;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class RegisterDto {

    String name;
    String surname;
    String email;
    String password;
    UserType userType;


}
