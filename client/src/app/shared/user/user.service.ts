import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'C:/Users/Admin/Individual-Exercise/SpringBoot/Accounts/client/node_modules/rxjs';
import { CommonModule } from '@angular/common';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<any> {
    console.log("user.service getAll ran")
    console.log("what is returned " + this.http.get('//localhost:8080/users'));
     return this.http.get('//localhost:8080/users');
   }

}
