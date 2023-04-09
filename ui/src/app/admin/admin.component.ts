import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { error } from 'console';
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private router : Router, private http : HttpClient) { }
  title = "ADMIN LIST"
  admins:any = []
  ngOnInit(): void {
    this.fetchAllAdmins();
  }
  addAdmin()
  {
    console.log("Add Admin button was clicked!");
    this.router.navigateByUrl('/add-admin');
  }
  fetchAllAdmins()
  {
    this.http.get('http://localhost:8080/admin/allAdmins').subscribe(resp => {this.admins = resp; console.log("Admins retreived successfully.", this.admins);} , error => {console.log("Error retreiving admin.", error);});
  }
  deleteAdmin(adminId:Number)
  {
    const url = 'http://localhost:8080/admin/deleteById/'+adminId;
    console.log(url);
    this.http.delete(url).subscribe(resp => {console.log("Admin deleted successfully."); this.fetchAllAdmins();} , error => {console.log("Error deleting admin.",error);});
  }
}
