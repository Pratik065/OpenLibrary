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
import com.xfactor.openlibrary.Domain.Publisher;
import com.xfactor.openlibrary.repositories.PublisherRepository;

@RestController
@RequestMapping("publisher")
public class PublisherController 
{
  PublisherRepository publisherRepository;
  
  public PublisherController(PublisherRepository publisherRepository) {
    this.publisherRepository = publisherRepository;
  }
  @PostMapping("/savePublisher")
  public Publisher savePublisher(@RequestBody Publisher publisher)
  {
    publisherRepository.save(publisher);
    return publisher;
  }
  @GetMapping("/allPublishers")
  public List<Publisher> getAllPublishers()
  {
    return publisherRepository.findAll();
  }
  @GetMapping("/getById/{id}")
  public Publisher getBookById(@PathVariable Long id)
  {
    Optional<Publisher> optionPublisher = publisherRepository.findById(id);
    if(optionPublisher.isPresent())
    {
      return optionPublisher.get();
    }
    return null;
  }
  @GetMapping("/getByName/{name}")
  public List<Publisher> getPublisherByName(@PathVariable String name)
  {
    List<Publisher> publishers = publisherRepository.getByName(name);
    return publishers;
  }
  @GetMapping("/getByAddress/{address}")
  public List<Publisher> getPublisherByAddress(@PathVariable String address)
  {
    List<Publisher> publishers = publisherRepository.getByAddress(address);
    return publishers;
  }
  @GetMapping("/getByPhone/{phone}")
  public List<Publisher> getPublishersByPhone(@PathVariable String phone)
  {
    List<Publisher> publishers = publisherRepository.getByPhone(phone);
    return publishers;
  }
  @GetMapping("/getByEmail/{email}")
  public List<Publisher> getPublishersByEmail(@PathVariable String email)
  {
    List<Publisher> publishers = publisherRepository.getByEmail(email);
    return publishers;
  }
  @DeleteMapping("/deleteById/{id}")
  public void deletePublisherId(@PathVariable Long id)
  {
    publisherRepository.deleteById(id);
  }
  @PutMapping("/updateById")
  public Publisher updatePublisherById(@RequestBody Publisher publisher)
  {
    if(publisher.getId()!=null)
    {
      Publisher publisher2 = publisherRepository.save(publisher);
      return publisher2;
    }
    return null;
  }
}
