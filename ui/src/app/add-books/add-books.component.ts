import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
@Component({
  selector: 'app-add-books',
  templateUrl: './add-books.component.html',
  styleUrls: ['./add-books.component.css']
})
export class AddBooksComponent implements OnInit {
  booksForm : FormGroup
  constructor(private router : Router, private http : HttpClient, private formbuilder : FormBuilder) { 
  this.booksForm = this.formbuilder.group({
    title:['', Validators.required],
    author:[],
    isbn:[],
    publicationDate:[],
    publisher:[],
    copies:[],
    category:[],
    genre:[],
    subgenre:[]
  })
}
  ngOnInit(): void {
  }
  saveBook()
  {
    let bookData = this.booksForm.value
    this.http.post('http://localhost:8080/books/saveBook',bookData).subscribe(response => {console.log("Book Saved to Database.", response); this.router.navigateByUrl('/book')}, error => {console.log("Error in Book Save",error)});
  }
}
