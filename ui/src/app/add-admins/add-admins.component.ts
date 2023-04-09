import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-admins',
  templateUrl: './add-admins.component.html',
  styleUrls: ['./add-admins.component.css']
})
export class AddAdminsComponent implements OnInit {
  adminsForm : FormGroup;
  constructor(private router : Router, private http : HttpClient, private formbuilder : FormBuilder) { 
    this.adminsForm = this.formbuilder.group(
      {
        name : ['', Validators.required],
        username : ['', Validators.required],
        password : ['', Validators.required]
      }
    )
  }

  ngOnInit(): void {
  }
  saveAdmin()
  {
    let adminData = this.adminsForm.value;
    this.http.post('http://localhost:8080/admin/saveAdmin',adminData).subscribe(response => {console.log("Admin added to database", response); this.router.navigateByUrl('/admin');}, error => {console.log("Error saving admin.", error);});
  }
}
