package com.example.bookstore.service.impl;

import com.example.bookstore.dto.RegisterDto;
import com.example.bookstore.entity.*;
import com.example.bookstore.repo.AuthRepository;
import com.example.bookstore.repo.AuthorRepository;
import com.example.bookstore.repo.UserRepository;
import com.example.bookstore.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RegisterServiceImpl implements RegisterService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Override
    public void saveRegister(RegisterDto registerDto) {
        Auth auth = Auth.builder()
                .name(registerDto.getName())
                .surname(registerDto.getSurname())
                .email(registerDto.getEmail())
                .password(passwordEncoder.encode(registerDto.getPassword()))
                .authorities(List.of(Authority.builder()
                                .userType(registerDto.getUserType())
                        .build()))
                .build();

            authRepository.save(auth);

        if (UserType.USER.equals(registerDto.getUserType())) {
            User user = new User();
            user.setName(registerDto.getName());
            user.setSurname(registerDto.getSurname());
            user.setEmail(registerDto.getEmail());
            user.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            userRepository.save(user);
        } else if (UserType.AUTHOR.equals(registerDto.getUserType())) {
            Author author = new Author();
            author.setName(registerDto.getName());
            author.setSurname(registerDto.getSurname());
            author.setEmail(registerDto.getEmail());
            author.setPassword(passwordEncoder.encode(registerDto.getPassword()));
            authorRepository.save(author);
        }



    }
}
