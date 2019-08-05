import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-error',
  templateUrl: './error.component.html',
  styleUrls: ['./error.component.css']
})
export class ErrorComponent implements OnInit {

  public errorMessage = 'Soemthing went wrong. Please contact support at *** - ***';
  constructor() { }

  ngOnInit() {
  }

}
