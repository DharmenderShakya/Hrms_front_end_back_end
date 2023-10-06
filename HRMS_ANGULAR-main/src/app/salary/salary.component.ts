import { Component, OnInit } from '@angular/core';
import {FormGroup,FormBuilder,Validators} from '@angular/forms';
import {Salary} from '../employee';
import {SalaryService} from '../salary.service';
import { Title } from '@angular/platform-browser';
declare var window:any;
@Component({
  selector: 'app-salary',
  templateUrl: './salary.component.html',
  styleUrls: ['./salary.component.css']
})
export class SalaryComponent implements OnInit {


  salaryModal:any;
  formValue:FormGroup;
  salary:Salary;
  list:Array<Salary>=[];
  constructor(private salaryService:SalaryService,private formBuilder:FormBuilder) { 
    this.formValue=this.formBuilder.group({
      id:['',Validators.required],
      salary:['',Validators.required],
      employeeName:['',Validators.required],
      months:['',Validators.required]
    })
   
  }

  ngOnInit(): void {
  this.getSalary();
    this.salaryModal=new window.bootstrap.Modal(

      document.getElementById("salaryModal")
    );
  }
updateModal=true;
savaModal=true;
title:any;
 openSaveModal(){
  this.updateModal=false;
  this.title="Add  Salary";
  this.savaModal=true;
  this.salaryModal.show();
 }
 salaryUpdate:any;
 openUpdateModal(id:any){
  this.updateModal=true;
  this.title="UpDate Salary";
  this.savaModal=false;
  this.salaryUpdate=id;
  this.salaryModal.show();
 }
 closeModal(){
  this.salaryModal.hide();
 }
getSalary(){
  this.salaryService.getSalary().subscribe(data=>{
    this.list=data;
  })
}

addSalary(data:any){
  this.salaryService.saveSalary(data).subscribe(data=>{
    this.salaryModal.hide();
    alert("Data is saved");
  })
}
getbyId(id:number){
this.salaryService.getSalaryById(id).subscribe(data=>{
this.list=data;
})
}
updateSalary(id:number,salary:Salary){
  this.salaryService.updateSalary(id,salary).subscribe(data=>{
  data=this.salary;
  this.salaryModal.hide();
  alert("updated successfully");
  
  })
}
deleteSalary(id:number){
  if(confirm("Do you want to delete"))
  this.salaryService.deleteSalary(id).subscribe(data=>{
  data=this.salary;
  })
}

}
