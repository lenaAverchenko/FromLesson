package com.telran.example.repository;

import com.telran.example.model.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAll();

    Book findOne(long isbn);

    Book borrowFromLibrary(long isbn);

    boolean returnToLibrary(Book book);
}
