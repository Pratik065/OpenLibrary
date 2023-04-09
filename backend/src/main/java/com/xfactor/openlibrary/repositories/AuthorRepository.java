package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{
  
  public List<Author> getByName(String name);
}
