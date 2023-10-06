import { Component, OnInit } from '@angular/core';
import { UsersService } from '../users.service';
import { User } from '../employee';
import {Router} from '@angular/router'
import { FormGroup,FormBuilder, Validators, FormControl } from '@angular/forms'; 
import {ToastrService} from 'ngx-toastr';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginData={
    userName:'',
    password:''
  }
  
  constructor(private loginService:UsersService,private toaster:ToastrService ,private router:Router) { 
  }

  ngOnInit(): void {
    // this.formSubmit();
  }

  public getUserToken(){
    this.loginService.getToken();
  }

formSubmit(){
  console.log(this.loginData.userName,this.loginData.password);

  if (this.loginData.userName.trim()=='' || this.loginData.userName==null) {
    this.toaster.error('user is required','',{
      timeOut:3000
    });
    return;
  }

  if (this.loginData.password.trim()=='' || this.loginData.password==null) {
    this.toaster.error('password is required','',{
      timeOut:2500
    })
    return;
  }
this.loginService.generateToken(this.loginData).subscribe((data:any)=>{
  this.loginService.userLogin(data.token);
  console.log("token",data.token);
this.loginService.getCurrentUser().subscribe((user:any)=>{
  this.loginService.setUser(user);
  if (this.loginService.getRole()=='ADMIN') {
    this.router.navigate(['/deshboard']);
    this.toaster.success('logins successfully','',{
      timeOut:3000
    });
  }
  else if (this.loginService.getRole()=='NORMAL') {
    this.router.navigate(['/deshboard']);
    this.toaster.success('logins successfully','',{
      timeOut:3000
    });
  }
  else{
    this.loginService.logOut();
  }

});
},
(error)=>{
this.toaster.error('Invalid Details','',{
  timeOut:3000,
});
})

}

}
