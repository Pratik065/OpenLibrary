package com.xfactor.openlibrary.controllers;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.Domain.Author;
import com.xfactor.openlibrary.repositories.AuthorRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
@RestController
@RequestMapping("author")
public class AuthorController 
{
  AuthorRepository authorRepository;
  
  public AuthorController(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }
  @PutMapping("/updateById")
  public Author updateAuthorById(@RequestBody Author author)
  {
    if(author.getId()!=null)
    {
      Author author2 = authorRepository.save(author);
      return author2;
    }
    return null;
  }
  @PostMapping("/saveAuthor")
  public Author saveAuthor(@RequestBody Author author)
  {
    authorRepository.save(author);
    return author;
  }
  @GetMapping("/allAuthors")
  public List<Author> getAllAuthors()
  {
    return authorRepository.findAll();
  }
  @GetMapping("/getById/{id}")
  public Author getBookById(@PathVariable Long id)
  {
    Optional<Author> optionAuthor = authorRepository.findById(id);
    if(optionAuthor.isPresent())
    {
      return optionAuthor.get();
    }
    return null;
  }
  @GetMapping("/getByName/{name}")
  public List<Author> getAuthorByName(String name)
  {
    List<Author> author = authorRepository.getByName(name);
    return author;
  }
  @DeleteMapping("/deleteById/{id}")
  public void deleteAuthorId(@PathVariable Long id)
  {
    authorRepository.deleteById(id);
  }
}
