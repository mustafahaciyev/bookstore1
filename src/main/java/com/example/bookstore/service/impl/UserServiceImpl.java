package com.example.bookstore.service.impl;

import com.example.bookstore.config.AppConfig;
import com.example.bookstore.config.UserMapper;
import com.example.bookstore.dto.LoginRequestDto;
import com.example.bookstore.dto.UserRegisterRequestDto;
import com.example.bookstore.entity.User;
import com.example.bookstore.repo.UserRepository;
import com.example.bookstore.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final AppConfig appConfig;
    private final UserMapper userMapper;


//    @Override
//    public long saveRegister(UserRegisterRequestDto userRegisterRequestDto) {
//        User register = appConfig.getMapper().map(userRegisterRequestDto, User.class);
//       return userRepository.save(register).getId();
//    }

//    @Override
//    public String login3(LoginRequestDto loginRequestDto) {
//        String email = loginRequestDto.getEmail();
//        String password = loginRequestDto.getPassword();
//        Optional<User> register = userRepository.findByEmail(email);
//
////        if (email == null){
////            return null;
////        } if (!register.getPassword().equals(password) && ){
////            return null;
////        }
////        return register;
//
//        register.ifPresent(login ->{
//            if (login.getPassword().equals(loginRequestDto.getPassword()) && (login.getIsActive()==null || login.getIsActive())){
//                login.setIsActive(true);
//                userRepository.save(login);
//            }
//        });
//        return register.isPresent() ? "Succesfully login":
//                "User not found";
//    }





    @Override
    public ResponseEntity<?> login(LoginRequestDto loginRequest) {
        // Burada userType atributunu qeyd edin
        String userType = getUserTypeByEmail(loginRequest.getEmail());

        if (userType != null && userType.equals("user")) {
            // "user" olanlar sadə istifadəçilərdir
            // İstifadəçi girişi əlavə edin
            // ...

        } else if (userType != null && userType.equals("author")) {
            // "author" olanlar müəlliflərdir
            // Müəllif girişi əlavə edin
            // ...
        } else {
            // Yanlış userType-dır, xəta qaytarın
            return ResponseEntity.badRequest().body("Yanlış userType.");
        }

        // Giriş prosesi əlavə edin
        // ...
        return ResponseEntity.ok("dsf");
    }

    @Override
    public String getUserTypeByEmail(String email) {
        return null;
    }

    @Override
    public void registerUser(UserRegisterRequestDto userRegisterRequestDto) {
        User user = new User();
        user.setEmail(userRegisterRequestDto.getEmail());
        // Hash and set the password
        user.setPassword(userRegisterRequestDto.getPassword());
        user.setActive(false);
        userRepository.save(user);
    }

//    @Override
//    public String getUserTypeByEmail(String email) {
//        User user = userRepository.findByEmail(email);
//
//        if (user != null) {
//            return user.getUserType();
//        }
//
//        return null; // E-poçt tapılmadısa null qaytar
//    }

}
