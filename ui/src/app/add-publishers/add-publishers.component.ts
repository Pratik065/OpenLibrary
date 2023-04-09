import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-publishers',
  templateUrl: './add-publishers.component.html',
  styleUrls: ['./add-publishers.component.css']
})
export class AddPublishersComponent implements OnInit {
  publishersForm : FormGroup;
  constructor(private router : Router, private http : HttpClient, private formbuilder : FormBuilder) { 
    this.publishersForm = this.formbuilder.group(
      {
        name : ['', Validators.required],
        address : [],
        phone : [],
        email : []
      }
    )
  }

  ngOnInit(): void {
  }
  savePublisher()
  {
    let publisherData = this.publishersForm.value;
    this.http.post('http://localhost:8080/publisher/savePublisher', publisherData).subscribe(response => {console.log("Publisher saved to Database.", response); this.router.navigateByUrl('/publisher');}, error => {console.log("Error saving Publisher", error);})
  }
}
