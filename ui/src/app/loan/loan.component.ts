import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
@Component({
  selector: 'app-loan',
  templateUrl: './loan.component.html',
  styleUrls: ['./loan.component.css']
})
export class LoanComponent implements OnInit {

  constructor(private router : Router, private http : HttpClient) { }
  title = "LOAN MANAGEMENT SYSTEM"
  loans:any = [];
  ngOnInit(): void {
    this.fetchAllLoans();
  }
  addLoan()
  {
    console.log("Add Loan button was clicked.");
    this.router.navigateByUrl('/add-loan');
  }
  fetchAllLoans()
  {
    this.http.get('http://localhost:8080/loan/getAll').subscribe(resp => {this.loans = resp; console.log("Loans retreived successfully.", this.loans);} , error => {console.log("Error in retreiving loan.", error);});
  }
  deleteLoan(loanId:Number)
  {
    const url = 'http://localhost:8080/loan/deleteById/'+loanId;
    console.log(url);
    this.http.delete(url).subscribe(resp => {console.log("Loan deleted succesfully."); this.fetchAllLoans();} , error => {console.log("Error deleting loan.", error);});
  }
}
