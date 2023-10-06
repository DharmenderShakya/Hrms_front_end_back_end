import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import {HttpClient} from '@angular/common/http'
@Injectable({
  providedIn: 'root'
})
export class UsersService {

  private  baseUrl="/auth";
  constructor(private httpClient:HttpClient) { }

public getCurrentUser(){
  return this.httpClient.get(`${this.baseUrl}/current-user`);
}

public generateToken(loginData:any){
return this.httpClient.post( `${this.baseUrl}/generate-token`,loginData);
}

public userLogin(token:any){
  return localStorage.setItem('token',token);
}

public setUser(user:any){
return localStorage.setItem('user',JSON.stringify(user));
}

public logOut(){
  localStorage.removeItem('token');
  localStorage.removeItem('user');
  return true;
}

public isLoggedIn(){
  const tokenStorage=localStorage.getItem('token');
  if (tokenStorage==undefined || tokenStorage=='' || tokenStorage==null) {
    return false
  }else{
    return true;
  }
}


  public getToken(){
    return localStorage.getItem('token');
  }

  public getUser(){
    let user=localStorage.getItem('user');
    if (user !=null) {
      return JSON.parse(user);
    }
    else{
      this.logOut();
      return null;
    }
  }

  public getRole(){
    let role=this.getUser();
    return role.authorities[0].authority;
  }
}
