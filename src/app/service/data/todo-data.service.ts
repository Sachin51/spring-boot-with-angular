import { API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';


export class ToDo{
  constructor(public id:number,public description:String,targetDate:Date,username:String,isDone:boolean){
  }
}

@Injectable({
  providedIn: 'root'
})
export class TodoDataService {

  public msg:String;
  public todos: ToDo[];

  constructor(private httpClient: HttpClient) { }


  getAllToDos(username){
    console.log('Getting all todos for: '+username);
    return this.httpClient.get<ToDo[]>(`${API_URL}/todo/jpa/users/${username}/todos`);
  }

  deleteTodo(todo,username){
    console.log('Delete: '+todo);
    this.httpClient.delete(sessionStorage.getItem("AuthenticatedUser"),todo.getId()).subscribe(
      response => {
        console.log(response)
        this.msg = `Delete of Todo ${todo.getId()} Successful`;
        this.getAllToDos(username)
      },
      error => {
        console.log(error)
      }
    );
  }
}
