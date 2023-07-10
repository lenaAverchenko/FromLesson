package com.telran.example.controller;

import com.telran.example.model.Reader;
import com.telran.example.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/readers")
public class ReaderController {

    @Autowired
    private ReaderService readerService;

    @GetMapping
    public List<Reader> getAll() {
        return readerService.getAll();
    }

    @GetMapping("/{login}")
    public Reader getByLogin(@PathVariable(name = "login") String login) {
        return readerService.getByLogin(login);
    }

    @PostMapping
    public Reader create(@RequestBody Reader reader) {
        return readerService.create(reader);
    }
}
