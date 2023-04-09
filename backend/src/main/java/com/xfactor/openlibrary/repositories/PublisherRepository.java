package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Publisher;

public interface PublisherRepository extends JpaRepository<Publisher, Long>
{
  public List<Publisher> getByName(String name);

  public List<Publisher> getByAddress(String address);

  public List<Publisher> getByPhone(String phone);

  public List<Publisher> getByEmail(String email);
}
