package com.telran.example.controller;

import com.telran.example.model.Book;
import com.telran.example.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:8080
@RestController
@RequestMapping("books") //http://localhost:8080/books
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping //http://localhost:8080/books
    public List<Book> list() {
        return bookService.getAll();
    }

    @GetMapping("/{isbn}") //http://localhost:8080/books/12345
    public Book getByIsbn(@PathVariable(name = "isbn") long isbn) {
        return bookService.findOne(isbn);
    }


    @PostMapping("/return")
    public void returnBookToLibrary(@RequestBody Book book) {
        bookService.returnToLibrary(book);
    }

    @PostMapping("/borrow/{isbn}")
    public void borrowFromLibrary(@PathVariable(name = "isbn") long isbn) {
        bookService.borrowFromLibrary(isbn);
    }
}

