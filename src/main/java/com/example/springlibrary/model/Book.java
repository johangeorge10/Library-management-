package com.example.springlibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Book {
    @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;
   private String name;
    String genre;
    float price;
    int count;
    @ManyToOne
    @JsonIgnore
    private Author author;

    public Book() {
        this(0L,"","",0F,0);
    }

    public Book(long id, String name, String genre, float price, int count) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.price = price;
        this.count = count;
    }

    public long getID() {
        return id;
    }

    public void setID(long ID) {
        this.id = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

}
