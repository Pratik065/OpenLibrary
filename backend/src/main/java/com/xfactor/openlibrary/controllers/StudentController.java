package com.xfactor.openlibrary.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.xfactor.openlibrary.Domain.Student;
import com.xfactor.openlibrary.repositories.StudentRepository;

@RestController
@RequestMapping("student")
public class StudentController 
{    
    StudentRepository studentRepository;
    
    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student)
    {
        studentRepository.save(student);
        return student;
    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents()
    {
        return studentRepository.findAll();
    }
    @GetMapping("/getById/{id}")
    public Student getBookById(@PathVariable Long id)
    {
        Optional<Student> optionStudent = studentRepository.findById(id);
        if(optionStudent.isPresent())
        {
          return optionStudent.get();
        }
        return null;
    }
    @GetMapping("/getByName/{name}")
    public List<Student> getStudentsByName(@PathVariable String name)
    {
        List<Student> students = studentRepository.getByName(name);
        return students;
    }
    @GetMapping("/getByDepartment/{department}")
    public List<Student> getStudentsByDepartment(@PathVariable String department)
    {
        List<Student> students = studentRepository.getByDepartment(department);
        return students;
    }
    @GetMapping("/getByRollNumber/{rollNumber}")
    public List<Student> getStudentsByRollNumber(@PathVariable String rollNumber)
    {
        List<Student> students = studentRepository.getByRollNumber(rollNumber);
        return students;
    }
    @GetMapping("/getBymobileNumber/{mobileNumber}")
    public List<Student> getStudentByMobileNumber(@PathVariable String mobileNumber)
    {
        List<Student> students = studentRepository.getBymobileNumber(mobileNumber);
        return students;
    }
    @DeleteMapping("/deleteById/{id}")
    public void deleteBookId(@PathVariable Long id)
    {
        studentRepository.deleteById(id);
    }
    @PutMapping("/updateById")
    public Student updateStudentById(@RequestBody Student student)
    {
        if(student.getId()!=null)
        {
            Student student2 = studentRepository.save(student);
            return student2;
        }
        return null;
    }
}
