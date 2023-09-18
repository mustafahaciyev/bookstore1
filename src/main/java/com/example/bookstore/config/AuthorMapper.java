package com.example.bookstore.config;

import com.example.bookstore.dto.AuthorRegisterRequestDto;
import com.example.bookstore.entity.Author;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AuthorMapper {
    private final ModelMapper modelMapper;

    public Author toEntity(AuthorRegisterRequestDto authorRegisterRequestDto) {
        return modelMapper.map(authorRegisterRequestDto, Author.class);
    }
}
