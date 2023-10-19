package com.example.bookstore.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.csrf(AbstractHttpConfigurer::disable);
        httpSecurity.formLogin(login -> login.loginPage("/login").permitAll())
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(HttpMethod.POST, "/register/auth").permitAll()
                        .requestMatchers("/authors/**").hasAuthority("AUTHOR")
                        .requestMatchers("/users/**").hasAuthority("USER")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults());
        return httpSecurity.build();

    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
