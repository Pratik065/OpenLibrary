import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { error } from 'console';

@Component({
  selector: 'app-book',
  templateUrl: './book.component.html',
  styleUrls: ['./book.component.css']
})
export class BookComponent implements OnInit {

  constructor(private router:Router, private http:HttpClient) { }
  title = "BOOK MANAGEMENT SYSTEM"
  books : any= [];

  addBook()
  {
    console.log("Add Books Button was clicked!");
    this.router.navigateByUrl('/add-book');
  }
  isColor = true
  ngOnInit(): void {
    this.fetchAllBooks();
  }
  fetchAllBooks()
  {
    this.http.get('http://localhost:8080/books/allBooks').subscribe(resp => {this.books = resp; console.log("Books retrieved successfully.", this.books);}, error => {console.log("Error in retrieving books", error);});
  }
  deleteBook(bookId:Number)
  {
    const url = 'http://localhost:8080/books/deleteById/'+bookId;
    console.log(url);
    this.http.delete(url).subscribe(resp => {console.log("Book deleted successfully"); this.fetchAllBooks();}, error => {console.log("Error in deleting book.", error);});
  }
}
