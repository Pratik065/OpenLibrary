import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-authors',
  templateUrl: './add-authors.component.html',
  styleUrls: ['./add-authors.component.css']
})
export class AddAuthorsComponent implements OnInit {
  authorsForm : FormGroup
  constructor(private router : Router, private http : HttpClient, private formbuilder : FormBuilder) {
    this.authorsForm = this.formbuilder.group(
      {
        name:['', Validators.required],
        birthDate:[],
        nationality:[]
      }
    )
   }

  ngOnInit(): void {
  }
  saveAuthor()
  {
    let authorData = this.authorsForm.value;
    this.http.post('http://localhost:8080/author/saveAuthor',authorData).subscribe(response => {console.log("Author added to Database", response); this.router.navigateByUrl('/author');} , error => {console.log("Error in adding author", error)});
  }
}
