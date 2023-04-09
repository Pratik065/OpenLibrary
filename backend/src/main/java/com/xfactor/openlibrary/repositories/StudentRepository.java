package com.xfactor.openlibrary.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xfactor.openlibrary.Domain.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
  public List<Student> getByName(String name);

  public List<Student> getByDepartment(String department);

  public List<Student> getByRollNumber(String rollNumber);

  public List<Student> getBymobileNumber(String mobileNumber);
}
