package com.example.warmup.controllers;

import com.example.warmup.Author;
import com.example.warmup.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/books")
public class AuthorController {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    //HTTP Verbs
    @GetMapping
    public ResponseEntity<List<Author>> getAllBooks() {
        var authors = this.authorRepository.findAll();
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Author> createAuthor(@Valid @RequestBody Author author) {
        var author2 = this.authorRepository.save(author);
        return new ResponseEntity<>(author2, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteAuthor(@PathVariable Long id) {
        // Your delete logic goes here
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("{id}")
    public ResponseEntity<Author> updateAuthor(@Valid @RequestBody Author author, @PathVariable Long id) {
        var foundAuthor = this.authorRepository.findById(author.getName());

        if (foundAuthor.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            var updatedAuthor = foundAuthor.get();
            updatedAuthor.setId(author.getId());
            updatedAuthor.setName(author.getName());
            var updatedAuthorFromDatabase = this.authorRepository.save(updatedAuthor);
            return new ResponseEntity<>(updatedAuthorFromDatabase, HttpStatus.OK);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Author>> searchAuthors(@RequestParam String name) {
        List<Author> authors = this.authorRepository.findByAuthorContainingIgnoreCase(name);
        return new ResponseEntity<>(authors, HttpStatus.OK);
    }
}