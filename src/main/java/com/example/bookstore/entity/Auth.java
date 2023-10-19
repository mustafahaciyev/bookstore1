package com.example.bookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Auth {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;


    String name;
    String surname;

    @Column(unique = true)
    @Email
    String email;
    String password;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "auth_authority",
            joinColumns = @JoinColumn(name = "auth_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    List<Authority> authorities;

}
