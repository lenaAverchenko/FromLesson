package com.telran.example.repository;

import com.telran.example.model.Reader;

import java.util.List;

public interface ReaderRepository {
    List<Reader> getAll();

    Reader getByLogin(String login);

    Reader create(Reader reader);
}
