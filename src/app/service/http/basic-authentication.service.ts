import { API_URL } from './../../app.constants';
import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import {map} from 'rxjs/operators';

export const TOKEN = "token"
export const AUTHENTICATED_USER = "authenticatedUser"

@Injectable({
  providedIn: 'root'
})


export class BasicAuthenticationService {

  constructor(private http: HttpClient) { }



  authenticate(username, password) {
    console.log("Username: " + username + " : password: " + password);

  }


  executeAuthenticationService(username, password) {
    let basicAuthHeaderString = 'Basic ' + btoa(username + ':' + password);

    console.log("Username: " + username + " : password: " + password);
    console.log("Value: "+basicAuthHeaderString);
    console.log("Basic Authentication...............");
    
    
    let headers = new HttpHeaders({
      Authorization: 'Basic ' + btoa(username + ':' + password)
    })


    return this.http.get<AuthenticationBean>(`${API_URL}/auth/basicauth`,
      { headers }).pipe(
        map(
          data => {
            sessionStorage.setItem(AUTHENTICATED_USER, username);
            sessionStorage.setItem(TOKEN, basicAuthHeaderString);
            return data;
          }
        )
      );
  }


  executeJWTAuthenticationService(username, password) {

    console.log("Username: " + username + " : password: " + password);
    console.log("JWT Authentication.............");

    return this.http.post<any>(`${API_URL}/authenticate`,
      { username, password }).pipe(
        map(
          data => {
            sessionStorage.setItem(AUTHENTICATED_USER, username);
            sessionStorage.setItem(TOKEN, `Bearer ${data.token}`);
            return data;
          }
        )
      );
  }


  getAuthenticatedUser(){
    return sessionStorage.getItem(AUTHENTICATED_USER);
  }

  getAuthenticatedToken(){
    if(this.getAuthenticatedUser)
      return sessionStorage.getItem(TOKEN);
  }

  logout(){
    sessionStorage.removeItem(AUTHENTICATED_USER);
    sessionStorage.removeItem(TOKEN);
  }
}


export class AuthenticationBean {
  constructor(public msg: String) {

  }
}
