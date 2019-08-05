import { TodoDataService, ToDo } from './../service/data/todo-data.service';
import { Component, OnInit } from '@angular/core';
import { WelcomeDataService } from '../service/data/welcome-data.service';

@Component({
  selector: 'app-list-todos',
  templateUrl: './list-todos.component.html',
  styleUrls: ['./list-todos.component.css']
})
export class ListTodosComponent implements OnInit {

  public todos: ToDo[];
  public username: String = sessionStorage.getItem("AuthenticatedUser");

  constructor(private todoDataService: TodoDataService, private welcomeDataService:WelcomeDataService) { }

  ngOnInit() {
    console.log('Getting all todos for user: '+sessionStorage.getItem("Sachin"));
    this.todoDataService.getAllToDos("Sachin").subscribe(
      response => {
        console.log('list-todos: '+response);
        this.todos = response;
      }
    );
  }

  // deleteTodo(todo,username){
  //   console.log('Delete: '+todo);
  //   this.todoDataService.deleteTodo(sessionStorage.getItem("AuthenticatedUser"),todo.getId()).subscribe(
  //     response => {
  //       console.log(response)
  //       this.msg = `Delete of Todo ${todo.getId()} Successful`;
  //       this.getAllToDos(username)
  //     },
  //     error => {
  //       console.log(error)
  //     }
  //   );
  // }
}
