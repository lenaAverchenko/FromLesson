package com.telran.example.service;

import com.telran.example.model.Reader;
import com.telran.example.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {

    @Autowired
    private ReaderRepository readerRepository;

    @Override
    public List<Reader> getAll() {
        return readerRepository.getAll();
    }

    @Override
    public Reader getByLogin(String login) {
        return readerRepository.getByLogin(login);
    }

    @Override
    public Reader create(Reader reader) {
        return readerRepository.create(reader);
    }
}
