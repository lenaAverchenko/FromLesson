package com.telran.example.service;

import com.telran.example.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getAll();

    Book findOne(long isbn);

    Book borrowFromLibrary(long isbn);

    boolean returnToLibrary(Book book);
}
