package com.telran.example.service;

import com.telran.example.model.Reader;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReaderServiceImplTest {

    @Autowired
    private ReaderService readerService;

    @Disabled
    @Test
    void getAll() {
        assertEquals(3, readerService.getAll().size());
    }

    @Test
    void getByLogin() {
        Reader reader = readerService.getByLogin("oleh");
        assertEquals("Oleh", reader.getFirstName());
        assertEquals("Olehov", reader.getLastName());
        assertEquals(15, reader.getAge());

    }

    @Test
    void create() {
        Reader reader = readerService.create(new Reader("tosha", "89654", "Anton", "Antonov", 90));
        Reader readerToCheck = readerService.getByLogin("tosha");
        assertNotNull(readerToCheck);
        assertEquals("Anton", readerToCheck.getFirstName());
        assertEquals("Antonov", readerToCheck.getLastName());
        assertEquals(90, readerToCheck.getAge());
    }
}