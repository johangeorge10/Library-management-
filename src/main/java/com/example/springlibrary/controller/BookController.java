package com.example.springlibrary.controller;

import com.example.springlibrary.model.Author;
import com.example.springlibrary.model.Book;
import com.example.springlibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;
    @GetMapping("/{id}")
    public Book getBook(@PathVariable long id) {
        return bookService.getBookById(id);
    }
    @GetMapping("/{id}/author")
    public Author getAuthorByBook(@PathVariable long id) {
        return bookService.getAuthorByBooks(id);
    }

    @GetMapping(value = "/all")
    public List<Book> getAllData() {
        return bookService.getAllBooks();
    }


    @GetMapping(value = "/all", params = { "genre" })
    public List<Book> getAllData(@RequestParam(value = "genre") String genre ,@RequestParam(value = "name",required = false) String name) {
        return bookService.getBooksByGenre(genre);
    }

    @GetMapping(value = "/all", params = { "authorId" })
    public List<Book> getAllData(@RequestParam(value = "authorId") long authorId) {
        return bookService.getBooksByAuthorId(authorId);
    }
    @GetMapping(value = "/all", params = { "name" })

    public List<Book> getAllData(@RequestParam(value = "name") String name) {
        return bookService.getBooksByName(name);
    }

    @PostMapping("/add")
    public Book addData(@RequestParam(value = "authorId") long authorId,@RequestBody Book book) {
        return bookService.addBook(authorId,book);
    }

       @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable Long id)
       {
           if(bookService.deleteBookById(id))
           {
               return ResponseEntity.status(HttpStatus.OK).build();
           }

               return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
       }
       @PutMapping("/{id}")
       public ResponseEntity<?> updateBook(@PathVariable Long id,@RequestBody Book book)
       {
         Book result=bookService.updateBookById(id,book);
           if(result!=null)
               return ResponseEntity.status(HttpStatus.OK).body(result);

           return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found");
       }

}
