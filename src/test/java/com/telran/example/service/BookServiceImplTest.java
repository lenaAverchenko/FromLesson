package com.telran.example.service;

import com.telran.example.model.Author;
import com.telran.example.model.Book;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BookServiceImplTest {

    @Autowired
    private BookService bookService;

    @Test
    void getAll() {
        assertEquals(3, bookService.getAll().size());
    }

    @Test
    void findOne() {
        Book book = bookService.findOne(12345l);
        assertNotNull(book);
        assertEquals("Harry Potter1", book.getName());
        assertEquals("Rowling", book.getAuthor().getSurname());
        assertEquals(1995, book.getYear());
    }

    @Disabled
    @Test
    void borrowFromLibrary() {
        Book book = bookService.borrowFromLibrary(12346l);
        List<Book> all = bookService.getAll();
        assertEquals(2, all.size());

    }

    @Disabled
    @Test
    void returnToLibrary() {
        Book book = new Book("Harry Potter11", 12346l,
                new Author("J", "Rowling"), 1996);
        boolean returned = bookService.returnToLibrary(book);

        Book bookFromLibrary = bookService.findOne(12346l);
        assertNotNull(bookFromLibrary);
        assertEquals("HarryPotter2", book.getName());
        assertEquals("Rowling", book.getAuthor().getSurname());
        assertEquals(1996, book.getYear());

    }
}