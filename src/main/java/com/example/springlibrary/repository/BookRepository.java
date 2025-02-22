package com.example.springlibrary.repository;

import com.example.springlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    public List<Book> findByName(String Name);
    public List<Book> findByGenre(String Genre);
//    public List<Book> findByAuthorId(long AuthorId);

}
