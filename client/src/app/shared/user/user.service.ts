import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { CommonModule } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class UserService {

private let webPath = "http://localhost:8080/users";

constructor(private http: HttpClient) { }


getAll(): Observable < any > {
  console.log("user.service getAll ran");
  console.log("what is returned " + this.http.get('//localhost:8080/users'));
  return this.http.get(this.webPath);
}

  deleteById(id) {
    console.log("id is " + id);
    var testString = new String("http://localhost:8080/users/");
    console.log(testString);
    var idToDelete = new String(id);
    console.log(idToDelete + " " + id );

    var deletePath = testString.concat(idToDelete);
    console.log("deletePath is " + deletePath);
    console.log(this.webPath + '/' + id);
    // this.http.delete(this.webPath + '/' + id).subscribe(data => {
    //   this.users = data;
    // });
    this.http.delete(this.webPath + '/' + id).subscribe();
 }


 addUser(newUser) {
   console.log("addUser in user.service ran");
   this.http.post("//localhost:8080/users/add", newUser).subscribe();
 }

 editUser(editedUser) {
   console.log("service layer editedUser is " + editedUser);
   this.http.put("//localhost:8080/users/edit", editedUser).subscribe();
 }

}
