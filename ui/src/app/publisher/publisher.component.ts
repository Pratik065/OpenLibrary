import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-publisher',
  templateUrl: './publisher.component.html',
  styleUrls: ['./publisher.component.css']
})
export class PublisherComponent implements OnInit {

  constructor(private router : Router, private http : HttpClient) { }
  title = "PUBLISHER INFORMATION"
  publishers:any = [];
  ngOnInit(): void {
    this.fetchAllPublishers();
  }
  addPublisher()
  {
    console.log("Add Publisher button was clicked!");
    this.router.navigateByUrl('/add-publisher');
  }
  fetchAllPublishers()
  {
    this.http.get('http://localhost:8080/publisher/allPublishers').subscribe(resp => {this.publishers = resp; console.log("Publishers retreived successfully.", this.publishers);}, error => {console.log("Error retreiving publishers.", error);});
  }
  deletePublisher(publisherId:Number)
  {
    const url = 'http://localhost:8080/publisher/deleteById/'+publisherId;
    console.log(url);
    this.http.delete(url).subscribe(resp => {console.log("Publisher deleted successfully."); this.fetchAllPublishers();}, error => {console.log("Error deleting publisher.", error);});
  }
}
