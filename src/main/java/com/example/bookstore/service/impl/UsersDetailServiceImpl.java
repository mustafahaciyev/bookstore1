package com.example.bookstore.service.impl;

import com.example.bookstore.entity.Auth;
import com.example.bookstore.repo.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UsersDetailServiceImpl implements UserDetailsService {

    private final AuthRepository authRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Auth auth = authRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Failed"));

        return User.builder()
                .username(auth.getEmail())
                .password(auth.getPassword())
                .authorities(auth.getAuthorities().stream()
                        .map(authority -> new SimpleGrantedAuthority(authority.getUserType()
                                .name()))
                        .collect(Collectors.toSet()))
                .build();

    }
}
