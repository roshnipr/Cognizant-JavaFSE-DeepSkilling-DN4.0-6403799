package org.example.repository;

import java.util.Arrays;
import java.util.List;

public class BookRepository {
    public List<String> findAll() {
        return Arrays.asList("The Hobbit", "Lord of the Rings");
    }
}
