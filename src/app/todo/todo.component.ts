import { ToDo } from './../service/data/todo-data.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {

  public todo: ToDo;
  constructor() { }

  ngOnInit() {
  }

  saveToDo(todo){
    console.log(todo);
  }

}


