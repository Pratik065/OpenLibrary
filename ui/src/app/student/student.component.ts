import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  constructor(private router : Router, private http : HttpClient) { }
  title = "STUDENT INFORMATION"
  students:any = [];
  ngOnInit(): void {
    this.fetchAllStudents();
  }
  addStudent()
  {
    console.log("Add Student button was clicked!");
    this.router.navigateByUrl('/add-student');
  }
  fetchAllStudents()
  {
    this.http.get('http://localhost:8080/student/getAll').subscribe(resp => {this.students = resp; console.log("Students retreived successfully.", this.students);} , error => {console.log("Error retreiving students.", error);});
  }
  deleteStudent(studentId:Number)
  {
    const url = 'http://localhost:8080/student/deleteById/' + studentId;
    console.log(url);
    this.http.delete(url).subscribe(resp => {console.log("Student deleted successfully."); this.fetchAllStudents();}, error => {console.log("Error deleting student.", error);});
  }
}
