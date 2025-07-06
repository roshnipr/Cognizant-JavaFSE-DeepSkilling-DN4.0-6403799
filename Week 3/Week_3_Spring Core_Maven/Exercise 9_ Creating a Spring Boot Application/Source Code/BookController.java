package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookRepository bookReposoitory;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookReposoitory.findAll();
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookReposoitory.save(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookReposoitory.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Long id, @RequestBody Book updateBook) {
        return bookReposoitory.findById(id).map(book -> {
            book.setTitle(updateBook.getTitle());
            book.setAuthor(updateBook.getAuthor());
            return bookReposoitory.save(book);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookReposoitory.deleteById(id);
    }
}
