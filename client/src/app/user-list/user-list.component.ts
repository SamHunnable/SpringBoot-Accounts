import { Component, OnInit } from '@angular/core';
import {UserService} from '../shared/user/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: Array<any>;

  constructor(private userService: UserService) { }

  ngOnInit() {
    console.log("The init in user-list.component ran")
    this.userService.getAll().subscribe(data => {
      this.users = data;

    });
    console.log("what is in this.users " + this.users);
  }

}
