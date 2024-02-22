package com.example.demo_aop.controller;

import com.example.demo_aop.entity.Book;
import com.example.demo_aop.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> listingBooks(){
        System.out.println("------------ Get method ------------");
        return bookService.getAllBooks();
    }


    @PostMapping("/book")
    public ResponseEntity<String> post(){
        System.out.println("------------ Create method ------------");
        Book book = new Book.Builder().title("Les aventures de Tam").author("Pauline Laout").build();
        bookService.createBook(book);

        return ResponseEntity.ok("ok");
    }


}
