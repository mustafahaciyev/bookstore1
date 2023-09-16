package com.example.bookstore.config;

import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    private final ModelMapper modelMapper;

    @Autowired
    public UserMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User toEntity(UserRegisterRequestDto userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
