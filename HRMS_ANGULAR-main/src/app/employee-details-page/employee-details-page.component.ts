import { Component, OnInit } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';
import { Employee } from '../employee';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-employee-details-page',
  templateUrl: './employee-details-page.component.html',
  styleUrls: ['./employee-details-page.component.css']
})
export class EmployeeDetailsPageComponent implements OnInit {

  employee:Employee=new Employee();
  employeeDetails:Array<Employee>=[]
  address : any;
  id:any;
  constructor(private employeeService:EmployeeServiceService,private avti:ActivatedRoute) { 
    this.avti.params.subscribe(data=>{
      this.id=data['id'];
    })
  }

  ngOnInit(): void {
    this.getEmployeeDetails();
  }

getEmployeeDetails(){

  this.employeeService.employeeGetbyId(this.id).subscribe(data=>{

  this.employee=data;
  // this.employee.quelification=data;


  })
}


}
