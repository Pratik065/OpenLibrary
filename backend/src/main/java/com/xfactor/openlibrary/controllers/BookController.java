package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.Domain.Book;
import com.xfactor.openlibrary.repositories.BookRepository;
@RestController
@RequestMapping("books")
public class BookController 
{
  BookRepository bookRepository;
  
  public BookController(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }
  @PostMapping("/saveBook")
  public Book saveBook(@RequestBody Book book)
  {
    bookRepository.save(book);
    return book;
  }
  @GetMapping("/allBooks")
  public List<Book> getAllBooks()
  {
    return bookRepository.findAll();
  }
  @GetMapping("/getById/{id}")
  public Book getBookById(@PathVariable Long id)
  {
    Optional<Book> optionBook = bookRepository.findById(id);
    if(optionBook.isPresent())
    {
      return optionBook.get();
    }
    return null;
  }

  @DeleteMapping("/deleteById/{id}")
  public void deleteBookId(@PathVariable Long id)
  {
    bookRepository.deleteById(id);
  }

  @GetMapping("/getByName/{name}")
  public List<Book> getBookByName(@PathVariable String name)
  {
    List<Book> books = bookRepository.getByTitle(name);
    return books;
  }

  @GetMapping("/getByIsbn/{isbn}")
  public List<Book> getBookByIsbn(@PathVariable String isbn)
  {
    List<Book> books = bookRepository.getByIsbn(isbn);
    return books;
  }

  @GetMapping("/getByAuthor/{author}")
  public List<Book> getBooksByAuthor(@PathVariable String author)
  {
    List<Book> books = bookRepository.getByAuthor(author);
    return books;
  }

  @GetMapping("/getByCategory/{category}")
  public List<Book> getBooksByCategory(@PathVariable String category)
  {
    List<Book> books = bookRepository.getByCategory(category);
    return books;
  }

  @GetMapping("/getByPublisher/{publisher}")
  public List<Book> getBooksByPublisher(@PathVariable String publisher)
  {
    List<Book> books = bookRepository.getByPublisher(publisher);
    return books;
  }

  @GetMapping("/getByGenre/{genre}")
  public List<Book> getBooksByGenre(@PathVariable String genre)
  {
    List<Book> books = bookRepository.getByGenre(genre);
    return books;
  }

  @GetMapping("/getBySubgenre/{subgenre}")
  public List<Book> getBooksBySubgenre(@PathVariable String subgenre)
  {
    List<Book> books = bookRepository.getBySubgenre(subgenre);
    return books;
  }

  @PutMapping("/updateById")
  public Book updateBookById(@RequestBody Book book)
  {
    if(book.getId()!=null)
    {
      Book book2 = bookRepository.save(book);
      return book2;
    }
    return null;
  }
}
