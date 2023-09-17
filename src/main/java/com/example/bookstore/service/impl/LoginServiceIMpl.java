package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Author;
import com.example.bookstore.entity.User;
import com.example.bookstore.repo.AuthorRepository;
import com.example.bookstore.repo.UserRepository;
import com.example.bookstore.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceIMpl implements LoginService {

    private final UserRepository userRepository;
    private final AuthorRepository authorRepository;


    @Override
    public boolean authenticateUser(String email, String password) {

        // Find the user or author by email
        Optional<User> userOptional = userRepository.findByEmail(email);
        Optional<Author> authorOptional = authorRepository.findByEmail(email);

        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (password.equals(user.getPassword()) && !user.isActive()) {
                // Set isActive to true for successful login
                user.setActive(true);
                userRepository.save(user);
                return true;
            }
        } else if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            if (password.equals(author.getPassword())) {
                // Set isActive to true for successful login
                author.setActive(true);
                authorRepository.save(author);
                return true;
            }
        }

        return false;
    }
}

