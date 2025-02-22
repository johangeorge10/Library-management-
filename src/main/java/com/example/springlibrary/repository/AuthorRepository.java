package com.example.springlibrary.repository;

import com.example.springlibrary.model.Author;
import com.example.springlibrary.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
//    public String getName(long authorId);
}
