import { BasicAuthenticationService } from './../service/http/basic-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private route: Router, private basicAuthService: BasicAuthenticationService) { }

  ngOnInit() {
  }

  handleBasicAuthLogin(username,password){
    console.log('Entered: Username-- '+username+' : password -- '+password);
    
    this.basicAuthService.executeAuthenticationService(username,password)
      .subscribe(
        data => {
          console.log("Success Login: "+data);
          this.route.navigate(['welcome',username]);
        },
        error => {
          console.log("Error Login: "+error);
        }
      );
  }

  handleJWTAuthLogin(username,password){
    console.log('Entered: Username-- '+username+' : password -- '+password);
    
    this.basicAuthService.executeJWTAuthenticationService(username,password)
      .subscribe(
        data => {
          console.log("Success Login: "+data);
          this.route.navigate(['welcome',username]);
        },
        error => {
          console.log("Error Login: "+error);
        }
      );
  }

}
