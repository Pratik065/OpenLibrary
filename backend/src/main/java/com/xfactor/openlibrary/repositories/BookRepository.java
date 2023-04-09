package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
  
  public List<Book> getByTitle(String name);

  public List<Book> getByIsbn(String isbn);
  
  public List<Book> getByAuthor(String author);

  public List<Book> getByCategory(String category);

  public List<Book> getByPublisher(String publisher);

  public List<Book> getByGenre(String genre);

  public List<Book> getBySubgenre(String subgenre);
}
