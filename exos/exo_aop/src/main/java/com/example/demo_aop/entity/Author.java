package com.example.demo_aop.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String lastname;
    private String firstname;

    @OneToMany(mappedBy = "author")
    private List<Book> books;

    public Author() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    private Author(Author.Builder builder) {
        this.setId(builder.id);
        this.setLastname(builder.lastname);
        this.setFirstname(builder.firstname);
        this.setBooks(builder.books);
    }

    public static class Builder {
        private long id;
        private String lastname;
        private String firstname;
        private List<Book> books;

        public Author.Builder id(long id) {
            this.id = id;
            return this;
        }

        public Author.Builder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public Author.Builder firstname(String firstname) {
            this.firstname = firstname;
            return this;
        }

        public Author.Builder books(List<Book> books) {
            this.books = books;
            return this;
        }

        public Author build() {
            return new Author(this);
        }
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", books=" + books +
                '}';
    }
}