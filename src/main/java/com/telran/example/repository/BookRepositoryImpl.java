package com.telran.example.repository;

import com.telran.example.model.Author;
import com.telran.example.model.Book;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BookRepositoryImpl implements BookRepository {

    private Map<Long, Book> bookStorage = new HashMap<>();

    @PostConstruct
    private void init() {
        bookStorage.put(12345l, new Book("Harry Potter1", 12345l,
                new Author("J", "Rowling"), 1995));
        bookStorage.put(12346l, new Book("Harry Potter2", 12346l,
                new Author("J", "Rowling"), 1996));
        bookStorage.put(12347l, new Book("Harry Potter3", 12347l,
                new Author("J", "Rowling"), 1997));
    }

    @Override
    public List<Book> getAll() {
        return new ArrayList<>(bookStorage.values());
    }

    @Override
    public Book findOne(long isbn) {
        return bookStorage.get(isbn);
    }

    @Override
    public Book borrowFromLibrary(long isbn) {
        return bookStorage.remove(isbn);
    }

    @Override
    public boolean returnToLibrary(Book book) {
        bookStorage.put(book.getIsbn(), book);
        return true;
    }
}
