package com.example.warmup.repositories;

import com.example.warmup.Author;
import com.example.warmup.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, String> {
    List<Author> findByAuthorContainingIgnoreCase(String name);

}
