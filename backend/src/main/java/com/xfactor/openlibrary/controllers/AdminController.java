package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xfactor.openlibrary.Domain.Admin;
import com.xfactor.openlibrary.repositories.AdminRepository;
@RestController
@RequestMapping("admin")
public class AdminController 
{
  AdminRepository adminRepository;
  
  public AdminController(AdminRepository adminRepository) {
    this.adminRepository = adminRepository;
  }
  @PostMapping("/saveAdmin")
  public Admin saveAdmin(@RequestBody Admin admin)
  {
    adminRepository.save(admin);
    return admin;
  }
  @GetMapping("/allAdmins")
  public List<Admin> getAllAdmins()
  {
    return adminRepository.findAll();
  }
  @GetMapping("/getById/{id}")
  public Admin getBookById(@PathVariable Long id)
  {
    Optional<Admin> optionAdmin = adminRepository.findById(id);
    if(optionAdmin.isPresent())
    {
      return optionAdmin.get();
    }
    return null;
  }
  @DeleteMapping("/deleteById/{id}")
  public void deleteBookId(@PathVariable Long id)
  {
    adminRepository.deleteById(id);
  }
}
