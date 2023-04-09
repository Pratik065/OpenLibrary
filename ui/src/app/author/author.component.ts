import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http'; 
import { error } from 'console';
@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  constructor(private router:Router, private http:HttpClient) { }
  title = "LIST OF AUTHORS"
  authorList:any = []
  ngOnInit(): void {
    this.fetchAllAuthors();
  }
  addAuthor()
  {
    console.log("Add Author Button was clicked!");
    this.router.navigateByUrl('/add-author');
  }
  fetchAllAuthors()
  {
    this.http.get('http://localhost:8080/author/allAuthors').subscribe(resp => {this.authorList = resp; console.log("Authors retreived successfully.", this.authorList);}, error => {console.log("Error retrieving authors.", error);});
  }
  deleteAuthor(authorId:Number)
  {
    const url = 'http://localhost:8080/author/deleteById/'+authorId;
    console.log(url);
    this.http.delete(url).subscribe(resp => {console.log("Author deleted successfully."); this.fetchAllAuthors();}, error => {console.log("Error deleting author.", error);});
  }
}
