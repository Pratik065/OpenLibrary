import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-add-loans',
  templateUrl: './add-loans.component.html',
  styleUrls: ['./add-loans.component.css']
})
export class AddLoansComponent implements OnInit {
  loansForm : FormGroup;
  constructor(private router : Router, private http : HttpClient, private formbuilder : FormBuilder) {
    this.loansForm = this.formbuilder.group(
      {
        bookId : ['', Validators.required],
        studentId : ['', Validators.required],
        checkoutDate : ['', Validators.required],
        dueDate : ['', Validators.required],
        returnDate : ['', Validators.required]
      }
    )
   }

  ngOnInit(): void {
  }
  saveLoan()
  {
    let loanData = this.loansForm.value;
    this.http.post('http://localhost:8080/loan/saveLoan', loanData).subscribe(response => {console.log("Loan saved in database.", response); this.router.navigateByUrl('/loan');}, error => {console.log("Error in saving Loan", error);});
  }
}
