package com.xfactor.openlibrary.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long>{
  
}
