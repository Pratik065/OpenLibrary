package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.xfactor.openlibrary.Domain.Loan;
import com.xfactor.openlibrary.repositories.LoanRepository;
@RestController
@RequestMapping("loan")
public class LoanController 
{
  LoanRepository loanRepository;
  
  public LoanController(LoanRepository loanRepository) {
    this.loanRepository = loanRepository;
  }
  @PostMapping("/saveLoan")
  public Loan saveLoan(@RequestBody Loan loan)
  {
    loanRepository.save(loan);
    return loan;
  }
  @GetMapping("/getAll")
  public List<Loan> getAllLoan()
  {
    return loanRepository.findAll();
  }
  @GetMapping("/getById/{id}")
  public Loan getBookById(@PathVariable Long id)
  {
    Optional<Loan> optionLoan = loanRepository.findById(id);
    if(optionLoan.isPresent())
    {
      return optionLoan.get();
    }
    return null;
  }
  @DeleteMapping("/deleteById/{id}")
  public void deleteBookId(@PathVariable Long id)
  {
    loanRepository.deleteById(id);
  }
  @PutMapping("/updateById")
  public Loan updateLoanById(@RequestBody Loan loan)
  {
    if(loan.getId()!=null)
    {
      Loan loan2 = loanRepository.save(loan);
      return loan2;
    }
    return null;
  }
}
