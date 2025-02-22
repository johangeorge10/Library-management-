package com.example.springlibrary.controller;

import com.example.springlibrary.model.Author;
import com.example.springlibrary.model.Book;
import com.example.springlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class authorController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{id}")
    public Author getAuthor(@PathVariable long id) {
        return bookService.getAuthorDetails(id);
    }
    @GetMapping("")
    public List<Author> getAuthors() {
        return bookService.getAuthors();
    }
    @PostMapping("/add")
    public Author addAuthor(@RequestBody Author author){
        return bookService.addAuthor(author);
    }
}
