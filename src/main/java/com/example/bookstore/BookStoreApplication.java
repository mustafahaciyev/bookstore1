package com.example.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

//	Task :
//	Bookstore temsil eden app yazilmasi
//	Telebler :
//	1. Register olmaq name, surname, email, password, userType (author or user)
//  2. Login olmaq email ve password ile eger db hemin credentials yoxdusa error qayitsin varsa db de elave column(isActive) olsun onu true elesin
//	Book terefi :
//	Eger login olubsa isActive true asagidaki emeliyyatlar icaze olacaq eks halda xeta atsin
//	Login olan author ise book :
//1. book save (eyni adla bir book olar)
//2. Get books (author oz book larini )
//3. Get book with name
//4. Update book
//5. Delete book only self book
//	Login olan user ise
//1. Get all books
//2. Get books name or author
//3. Save, update, delete user ede bilmesin

}
