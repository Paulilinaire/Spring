package com.example.demo_aop.service;

import com.example.demo_aop.entity.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private final List<Book> books = new ArrayList<>();

    public void createBook(Book book) {
        books.add(book);
    }

    public void deleteBook(int bookId) {
        books.removeIf(book -> book.getId() == (bookId));}

    public List<Book> getAllBooks() {
        return books;
    }

}
