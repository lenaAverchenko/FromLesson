package com.telran.example.service;


import com.telran.example.model.Reader;
import com.telran.example.repository.ReaderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ReaderService {

    List<Reader> getAll();

    Reader getByLogin(String login);

    Reader create(Reader reader);
}
