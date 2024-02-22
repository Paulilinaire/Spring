package com.example.demo_aop.controller;

import com.example.demo_aop.dto.AuthorDTO;
import com.example.demo_aop.dto.BookDTO;
import com.example.demo_aop.entity.Author;
import com.example.demo_aop.entity.Book;
import com.example.demo_aop.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> save(@RequestBody BookDTO bookDTO, @RequestBody AuthorDTO authorDTO) {
        Author author = new Author.Builder()
                .lastname(authorDTO.getLastname())
                .firstname(authorDTO.getFirstname())
                .build();

        Book book = bookService.save(bookDTO.getTitle(), author);
        return ResponseEntity.ok(book);
    }


    @GetMapping
    public ResponseEntity<List<Book>> get() {
        List<Book> books = bookService.findAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> get(@PathVariable long id) {
        return ResponseEntity.ok(bookService.findById(id));
    }
}