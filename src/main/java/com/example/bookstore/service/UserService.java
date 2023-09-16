package com.example.bookstore.service;

import com.example.bookstore.dto.LoginRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
//    long saveRegister(UserRegisterRequestDto userRegisterRequestDto);

    

//    void registerUser(UserRegisterRequestDto userRegisterRequestDto);

    ResponseEntity<?> login(LoginRequestDto loginRequest);
    String getUserTypeByEmail(String email);

    void registerUser(UserRegisterRequestDto userRegisterRequestDto);
}
