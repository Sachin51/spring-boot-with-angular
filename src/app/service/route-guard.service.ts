import { BasicAuthenticationService } from './http/basic-authentication.service';
import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';

export const TOKEN = "token"
export const AUTHENTICATED_USER = "authenticatedUser"

@Injectable({
  providedIn: 'root'
})

export class RouteGuardService implements CanActivate{

  constructor(private basicAuthenticationService:BasicAuthenticationService) { }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot){
    if(sessionStorage.getItem(AUTHENTICATED_USER) && sessionStorage.getItem(TOKEN)){
      return true;
    }
  }
}
