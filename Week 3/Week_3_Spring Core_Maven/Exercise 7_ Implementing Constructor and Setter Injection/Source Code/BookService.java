package org.example.service;

import org.example.repository.BookRepository;

public class BookService {
    private BookRepository bookRepository;
    private String libraryName;

    public BookService(String libraryName) {
        this.libraryName = libraryName;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        System.out.println("Library: " + libraryName);
        bookRepository.findAll().forEach(System.out::println);
    }
}
