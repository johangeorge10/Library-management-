package com.example.springlibrary.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany
   private List<Book> books=new ArrayList<>();

    public Author(){
        this(0L,"");
    };
    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

//    @Override
//    public String toString() {
//        return "author{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", books=" + books +
//                '}';
//    }
}
