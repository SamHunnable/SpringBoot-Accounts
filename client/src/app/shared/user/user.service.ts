import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class UserService {

private let webPath = "//localhost:8080/users";

constructor(private http: HttpClient) { }


getAll(): Observable < any > {
  console.log("user.service getAll ran");
  console.log("what is returned " + this.http.get('//localhost:8080/users'));
  return this.http.get(this.webPath);
}

  deleteById(id) {
    console.log("id is " + id);
    path: String = "localhost:8080/users/" + id;
    console.log("path is " + this.path);
    this.http.delete(this.path);
 }

 addUser(newUser) {
   console.log("addUser in user.service ran");
   this.http.post("//localhost:8080/users", newUser);
 }

}
