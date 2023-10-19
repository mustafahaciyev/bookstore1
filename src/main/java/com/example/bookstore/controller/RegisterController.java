package com.example.bookstore.controller;

import com.example.bookstore.dto.RegisterDto;
import com.example.bookstore.service.RegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @PostMapping("auth")
    public ResponseEntity<String> saveRegister(@Valid @RequestBody RegisterDto registerDto){
        registerService.saveRegister(registerDto);
        return ResponseEntity.ok("Save success");
    }


}
