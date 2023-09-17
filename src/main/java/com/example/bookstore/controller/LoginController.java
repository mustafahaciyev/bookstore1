package com.example.bookstore.controller;

import com.example.bookstore.dto.LoginRequestDto;
import com.example.bookstore.service.LoginService;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;


    @PostMapping
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginDto) {
        boolean loginSuccessful = loginService.authenticateUser(loginDto.getEmail(), loginDto.getPassword());

        if (loginSuccessful) {
            return ResponseEntity.ok("Login successful.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Login failed.");
        }
    }



}
