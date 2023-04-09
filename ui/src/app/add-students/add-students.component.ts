import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-students',
  templateUrl: './add-students.component.html',
  styleUrls: ['./add-students.component.css']
})
export class AddStudentsComponent implements OnInit {
  studentsForm : FormGroup;
  constructor(private router : Router, private http : HttpClient, private formbuilder : FormBuilder) { 
    this.studentsForm = this.formbuilder.group(
      {
        name : ['', Validators.required],
        department : [],
        rollNumber : [],
        birthDate : [],
        mobileNumber : []
      }
    )
  }

  ngOnInit(): void {
  }
  saveStudent()
  {
    let studentData = this.studentsForm.value;
    this.http.post('http://localhost:8080/student/saveStudent', studentData).subscribe(response => {console.log("Student saved in database.", response); this.router.navigateByUrl('/student');}, error => {console.log("Error saving student", error);});
  }
}
