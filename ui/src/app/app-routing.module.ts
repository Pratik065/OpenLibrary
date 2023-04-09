import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddAdminsComponent } from './add-admins/add-admins.component';
import { AddAuthorsComponent } from './add-authors/add-authors.component';
import { AddBooksComponent } from './add-books/add-books.component';
import { AddLoansComponent } from './add-loans/add-loans.component';
import { AddPublishersComponent } from './add-publishers/add-publishers.component';
import { AddStudentsComponent } from './add-students/add-students.component';
import { AdminComponent } from './admin/admin.component';
import { AuthorComponent } from './author/author.component';
import { BookComponent } from './book/book.component';
import { HomeComponent } from './home/home.component';
import { LoanComponent } from './loan/loan.component';
import { PublisherComponent } from './publisher/publisher.component';
import { StudentComponent } from './student/student.component';

const routes: Routes = [
  {
    path : "book",
    component : BookComponent
  },
  {
    path : "author",
    component : AuthorComponent
  },
  {
    path : "publisher",
    component : PublisherComponent
  },
  {
    path : "student",
    component : StudentComponent
  },
  {
    path : "loan",
    component : LoanComponent
  },
  {
    path : "admin",
    component : AdminComponent
  },
  {
    path : "",
    component : HomeComponent
  },
  {
    path : "add-book",
    component : AddBooksComponent
  },
  {
    path : "add-author",
    component : AddAuthorsComponent
  },
  {
    path : "add-publisher",
    component : AddPublishersComponent
  },
  {
    path : "add-student",
    component : AddStudentsComponent
  },
  {
    path : "add-loan",
    component : AddLoansComponent
  },
  {
    path : "add-admin",
    component : AddAdminsComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
