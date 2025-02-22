package com.example.springlibrary.service;

import com.example.springlibrary.model.Author;
import com.example.springlibrary.model.Book;
import com.example.springlibrary.repository.AuthorRepository;
import com.example.springlibrary.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;




    public Book addBook(Long AuthorId,Book book) {
        if (authorRepository.findById(AuthorId).isPresent())
        {
            Author author =authorRepository.findById(AuthorId).get();
            List<Book> books=author.getBooks();
            book.setAuthor(author);
            Book res =bookRepository.save(book);
            books.add(book);
            author.setBooks(books);
            authorRepository.save(author);
            return res;
        }
        return null;
    }
    public Book getBookById(long bookId)
    {
        Optional<Book> res = bookRepository.findById(bookId);
        if(res.isPresent())
        {
            return res.get();

        }
        return null;
    }

    public List<Book> getAllBooks()
    {
        return bookRepository.findAll();
    }
    public List<Book> getBooksByName(String name)
    {
        return bookRepository.findByName(name);
    }

    public List<Book> getBooksByGenre(String genre)
    {
        return bookRepository.findByGenre(genre);
    }
    public List<Book> getBooksByAuthorId(long authorId)
    {
        if(authorRepository.findById(authorId).isPresent()) {
            Author author=authorRepository.findById(authorId).get();
            List<Book> books=author.getBooks();
            Comparator<Book> priceComparator = Comparator.comparing(Book::getPrice);

            Collections.sort(books,priceComparator);
            return author.getBooks();
        }
        return null;
    }
    public boolean deleteBookById(long id){
        if(bookRepository.findById(id).isPresent()) {
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
    public Book updateBookById(long id,Book book){
        if(bookRepository.findById(id).isPresent()) {
            book.setID(id);
            bookRepository.save(book);
            return book;
        }
        return null;
    }
     public Author getAuthorDetails(long id){
         if(authorRepository.findById(id).isPresent()) {
             return authorRepository.findById(id).get();
         }
         return null;
     }
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

  public Author addAuthor(Author author){
        return authorRepository.save(author);
  }

   public Author getAuthorByBooks(long id) {
       if (bookRepository.findById(id).isPresent())
       {
          return bookRepository.findById(id).get().getAuthor();
       }
        return null;
   }
}

