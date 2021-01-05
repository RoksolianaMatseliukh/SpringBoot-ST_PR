package com.oktenweb.springbootstpr.controllers;

import com.oktenweb.springbootstpr.entities.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BookController {

    private List<Book> books = new ArrayList<>();

    {
        books.add(new Book(1, "book1", "author1"));
        books.add(new Book(2, "book2", "author2"));
        books.add(new Book(3, "book3", "author3"));
    }

    @GetMapping(value = "/books")
    public List<Book> getBooks() {
        return books;
    }
}
