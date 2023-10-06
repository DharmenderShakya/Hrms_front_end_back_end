import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeServiceService } from '../employee-service.service';

@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css']
})
export class NavbarComponent implements OnInit {

  @Output() toggle=new EventEmitter();
  constructor(private router:Router,private employeeService:EmployeeServiceService) {

   }
employee=true;
leave=false;
salary=false;
project=false;
   showChildModal() {
    this.employeeService.childModal = true;
  }
  toggleSidebar(){
    this.toggle.emit(); 
  }

  ngOnInit(): void {
  }

}
