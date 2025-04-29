package com.example.BookNest.controller;

import com.example.BookNest.model.Book;
import com.example.BookNest.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired private BookRepository bookRepo;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    @GetMapping("/genre/{genre}")
    public List<Book> getByGenre(@PathVariable String genre) {
        return bookRepo.findByGenre(genre);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable Long id) {
        return bookRepo.findById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }
}
