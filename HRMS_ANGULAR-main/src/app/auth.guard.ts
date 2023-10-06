import { Injectable, inject } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { UsersService } from './users.service';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  constructor(private authService :UsersService,private router:Router){}
  canActivate(next: ActivatedRouteSnapshot,state: RouterStateSnapshot):boolean{
    if (this.authService.isLoggedIn()) {
      return true;
    }
    this.router.navigate(['/login']);
    return false;
  }
  
}
export const LoginAuthGurd :CanActivateFn=(next:ActivatedRouteSnapshot,state:RouterStateSnapshot):boolean=>{
  return inject(AuthGuard).canActivate(next,state);
}