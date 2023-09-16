//package com.example.bookstore.entity;
//
//public class A {
//    import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//    @Service
//    public class UserServiceImpl implements UserService {
//
//        private final UserRepository userRepository;
//        private final UserMapper userMapper;
//
//        @Autowired
//        public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
//            this.userRepository = userRepository;
//            this.userMapper = userMapper;
//        }
//
//        @Override
//        public User registerUser(UserDTO userDTO) {
//            // Kullanıcı kaydı kodları burada
//
//            return user;
//        }
//
//        @Override
//        public User loginUser(LoginDTO loginDTO) {
//            // Kullanıcıyı e-posta ve şifre ile arayın
//            User user = userRepository.findByEmailAndPassword(loginDTO.getEmail(), loginDTO.getPassword());
//
//            if (user != null) {
//                // Giriş başarılı ise isActive'i true yap
//                user.setIsActive(true);
//                userRepository.save(user);
//            }
//
//            return user;
//        }
//
//        @Override
//        public void logoutUser(Long userId) {
//            // Kullanıcının isActive değerini false yap
//            User user = userRepository.findById(userId).orElse(null);
//            if (user != null) {
//                user.setIsActive(false);
//                userRepository.save(user);
//            }
//        }
//    }
//    @RestController
//    @RequestMapping("/users")
//    public class UserController {
//
//        private final UserService userService;
//
//        @Autowired
//        public UserController(UserService userService) {
//            this.userService = userService;
//        }
//
//        @PostMapping("/register")
//        public ResponseEntity<String> registerUser(@RequestBody UserDTO userDTO) {
//            userService.registerUser(userDTO);
//            return new ResponseEntity<>("User registered successfully.", HttpStatus.CREATED);
//        }
//
//        @PostMapping("/login")
//        public ResponseEntity<String> loginUser(@RequestBody LoginDTO loginDTO) {
//            User user = userService.loginUser(loginDTO);
//
//            if (user != null) {
//                return new ResponseEntity<>("Login successful.", HttpStatus.OK);
//            } else {
//                return new ResponseEntity<>("Login failed. Invalid email or password.", HttpStatus.UNAUTHORIZED);
//            }
//        }
//
//        @PostMapping("/logout/{userId}")
//        public ResponseEntity<String> logoutUser(@PathVariable Long userId) {
//            userService.logoutUser(userId);
//            return new ResponseEntity<>("Logout successful.", HttpStatus.OK);
//        }
//    }
//
//}
