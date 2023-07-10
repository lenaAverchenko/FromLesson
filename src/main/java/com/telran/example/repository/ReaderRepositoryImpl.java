package com.telran.example.repository;

import com.telran.example.model.Reader;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ReaderRepositoryImpl implements ReaderRepository {

    Map<String, Reader> readersMap = new HashMap<>();

    @PostConstruct
    private void init() {
        readersMap.put("oleh", new Reader("oleh", "12345", "Oleh", "Olehov", 15));
        readersMap.put("ola", new Reader("ola", "12346", "Ola", "Olehovna", 55));
        readersMap.put("dima", new Reader("dima", "12347", "Dima", "Dmitrov", 20));

    }

    @Override
    public List<Reader> getAll() {
        return new ArrayList<>(readersMap.values());
    }

    @Override
    public Reader getByLogin(String login) {
        return readersMap.get(login);
    }

    @Override
    public Reader create(Reader reader) {
        readersMap.put(reader.getLogin(), reader);
        return reader;
    }
}
