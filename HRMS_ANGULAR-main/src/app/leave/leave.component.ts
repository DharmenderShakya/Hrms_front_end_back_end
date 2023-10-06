import { Component, OnInit } from '@angular/core';
import {FormBuilder,FormControl,FormGroup,Validators} from '@angular/forms'
import { LeaveServiceService } from '../leave-service.service';
import {Employee, Leave} from '../employee';
import {BsDatepickerModule} from 'ngx-bootstrap/datepicker'
import { EmployeeServiceService } from '../employee-service.service';
declare var window:any;
@Component({
  selector: 'app-leave',
  templateUrl: './leave.component.html',
  styleUrls: ['./leave.component.css']
})
export class LeaveComponent implements OnInit {
  leaveModal:any;
  formValue:FormGroup;
  leaves:Leave;
  employee:Array<Employee>=[]
  list:Array<Leave>=[];
  file:File;

  constructor(private leaveService:LeaveServiceService,private formBuilder:FormBuilder,private employeeService:EmployeeServiceService) { 
    // this.formValue=this.formBuilder.group({
    //   employee_Name:['',Validators.required],
    //   id:['',Validators.required],
    //   reason:['',Validators.required],
    //   startDate:['',Validators.required],
    //   endDate:['',Validators.required],
    //   description:['',Validators.required]
    // })
    this.formValue = new FormGroup({
      id : new FormControl(),
      employeeName : new FormControl(),
      reason : new FormControl(),
      startDate : new FormControl(),
      endDate : new FormControl(),
      description  : new FormControl(),
      employeeId:new FormControl()
    })
    
  }

  ngOnInit(): void {
this.getLeave()
this.leaveModal=new window.bootstrap.Modal(

  document.getElementById("leaveModal")
);
  }

  update=true;
  save=true;
  title:any;
 openSaveModal(){
  this.update=false;
  this.title="Add Leave"
  this.save=true;
  this.leaveModal.show();
  this.employeeService.getEmployeeDetails().subscribe(data=>{
    this.employee=data;
    console.log('employeeDetails',data);
    this.formValue.get('employeeName').setValue(data.firstName);
  })
 }
li:any;
 openUpdateModal(id:any){
  this.update=true;
  this.title="Update Leave"
  this.save=false;
  this.li=id;
  this.leaveModal.show();
 }
 closeModal(){
  this.leaveModal.hide();
 }
getLeave(){
  this.leaveService.getLeave().subscribe(data=>{
    this.list=data;
  })
}


addLeave(data:any){
  console.log(data);
  console.log(this.formValue.get('employeeId').value);
  
  
  this.leaveService.saveLeave(data).subscribe(data=>{
    // data=this.leaves;
  })
  this.uploadImage();
    alert("Save Sucussfully..");
    this.leaveModal.hide()  
}
getbyId(id:number){
this.leaveService.getLeaveById(id).subscribe(data=>{
this.list=data;
})
}
updateLeave(id:number,leave:Leave){
  this.leaveService.updateLeave(id,leave).subscribe(data=>{
    alert("Update Sucussfully..");
    this.leaveModal.hide()
  data=this.leaves;
  })
}
deleteLeave(id:number){
  if(confirm("Do you want to delete"))
  this.leaveService.deleteLeave(id).subscribe(data=>{
   })
}
uploadfile(event){
this.file=event.target.files[0];
}

uploadImage(){

  this.leaveService.uploadFile(this.file).subscribe(data=>{

  })
}

}

