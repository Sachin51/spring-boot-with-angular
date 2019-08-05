import { BasicAuthenticationService } from './../service/http/basic-authentication.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {

  constructor(private basicAuthenticationService: BasicAuthenticationService, private route:Router) { }

  ngOnInit() {
  }

  logout(){
    console.log('Calling logout..................');
    this.basicAuthenticationService.logout();
    this.route.navigate(['login']);
  }
}
