import { API_URL } from './../../app.constants';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

export class HelloWorldBean{
  constructor(public msg: String){
  }
}



@Injectable({
  providedIn: 'root'
})
export class WelcomeDataService {

  constructor(private _httpClient:HttpClient) { }

  executeHelloWorld(){
    return this._httpClient.get<HelloWorldBean>(`${API_URL}/hello/greeting/Sachin`);
  }

  executeHelloWorldWithPathVariable(name){
    return this._httpClient.get<HelloWorldBean>(`${API_URL}/hello/greeting/pathvariable/${name}`);
  }

  executeToDo(name){
    console.log('Result: '+this._httpClient.get<any>(`${API_URL}/todo/jpa/users/${name}/todos`));
    return this._httpClient.get<any>(`${API_URL}/todo/jpa/users/${name}/todos`);
  }
}
