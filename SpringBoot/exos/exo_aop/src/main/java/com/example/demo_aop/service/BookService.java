package com.example.demo_aop.service;

import com.example.demo_aop.entity.Author;
import com.example.demo_aop.entity.Book;
import com.example.demo_aop.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save(String title, Author author) {
        Book book = new Book.Builder()
                .title(title)
                .author(author)
                .build();
        return bookRepository.save(book);
    }



    public Book findById(long id) {
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }
        throw new RuntimeException("Not found");
    }


    public List<Book> findAll() {
        List<Book> books = (List<Book>) bookRepository.findAll();
        return books;
    }

    public void delete(long id){
        bookRepository.deleteById(id);
    }

}
