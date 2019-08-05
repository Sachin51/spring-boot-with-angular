import { WelcomeDataService } from './../service/data/welcome-data.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  public errorMsg;
  public userName;
  public customMsg;
  constructor(private route: ActivatedRoute, private welcomeDataService: WelcomeDataService) {

   }

  ngOnInit() {
    this.userName = this.route.snapshot.params['name'];
  }

  getToDos(username){
    console.log("Getting Todos.....");
    this.welcomeDataService.executeToDo(username).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }


  getWelcomeMessage(){
    console.log('Step 1:'+this.welcomeDataService.executeHelloWorld());
    this.welcomeDataService.executeHelloWorld().subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }


  executeHelloWorldWithPathVariable(name){
    console.log('Step 1:'+this.welcomeDataService.executeHelloWorldWithPathVariable(name));
    this.welcomeDataService.executeHelloWorldWithPathVariable(name).subscribe(
      response => this.handleSuccessfulResponse(response),
      error => this.handleErrorResponse(error)
    );
  }


  handleSuccessfulResponse(response){
    console.log('Handled Sucessful response: '+response.msg);
    this.customMsg = response.msg;
  }

  handleErrorResponse(error){
    this.errorMsg = error;
    console.log("Error is: "+this.errorMsg.error.message);
    
  }
}
