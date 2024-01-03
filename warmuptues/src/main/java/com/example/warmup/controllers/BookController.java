package com.example.warmup.controllers;

import com.example.warmup.Book;
import com.example.warmup.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class BookController {
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //HTTP Verbs
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        var books = this.bookRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book) {
        var book2 = this.bookRepository.save(book);
        return new ResponseEntity<>(book2, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        // Your delete logic goes here
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("{id}")
    public ResponseEntity<Book> updateBook(@Valid @RequestBody Book book, @PathVariable Long id) {
        var foundBook = this.bookRepository.findById(id);

        if (foundBook.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            var updatedBook = foundBook.get();
            updatedBook.setPrice(book.getPrice());
            updatedBook.setLikes(book.getLikes());
            var updatedBookFromDatabase = this.bookRepository.save(updatedBook);
            return new ResponseEntity<>(updatedBookFromDatabase, HttpStatus.OK); // Changed status to OK
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam String title) {
        List<Book> books = this.bookRepository.findByTitleContainingIgnoreCase(title);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}