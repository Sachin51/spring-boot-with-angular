import { ListTodosComponent } from './list-todos/list-todos.component';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ErrorComponent } from './error/error.component';
import { RouteGuardService } from './service/route-guard.service';

const routes: Routes = [
  {path: '', component: LoginComponent},
  {path: 'welcome/:name', component: WelcomeComponent},
  {path: 'login', component: LoginComponent},
  {path: 'todos', component: ListTodosComponent, canActivate: [RouteGuardService]},
  {path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
