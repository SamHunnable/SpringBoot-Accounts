import { Component, OnInit } from '@angular/core';
import { UserService } from '../shared/user/user.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: Array<any>;
  addingUserState: boolean = false;
  editingUserState: boolean = false;
  firstNameToEdit: String;
  lastNameToEdit: String;
  idToEdit: long;
  newFirstName: String;
  newLastName: String;

  constructor(private userService: UserService) { }

  ngOnInit() {
    console.log("The init in user-list.component ran")
    this.userService.getAll().subscribe(data => {
      this.users = data;
    });
    console.log("what is in this.users " + this.users);
  }

  cancelEdit() {
    this.editingUserState = false;
  }

  editUser(user) {
    this.firstNameToEdit = user.firstName;
    this.lastNameToEdit = user.lastName;
    this.idToEdit = user.id;
    this.editingUserState = true;
  }

  deleteUser(user) {
      console.log("delete ran");
      console.log(user.id);
      this.userService.deleteById(user.id);
    }

  addingUser() {
    this.addingUserState = !this.addingUserState;
  }

  saveUserEdit() {
    let editedUser: any = {};
    editedUser.id = this.idToEdit;
    editedUser.firstName = this.firstNameToEdit;
    editedUser.lastName = this.lastNameToEdit;
    console.log(editedUser);
    JSON.stringify(editedUser);
    console.log("editedUser is " + JSON.stringify(editedUser));
    this.userService.editUser(JSON.stringify(editedUser));
  }

  saveNewUser() {
    console.log("saveUser ran");
    let newUser: any = {};
    newUser.firstName = this.newFirstName;
    newUser.lastName = this.newLastName;
    console.log("newUser is " + this.newuser);
    this.userService.addUser(JSON.stringify(newUser));
  }

}
