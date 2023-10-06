import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { EmployeeServiceService } from '../employee-service.service';
import { Address, Employee, Quelification } from '../employee';
import { FormGroup, FormBuilder, Validators, FormArray, FormControl } from '@angular/forms';
import { ModalDirective } from 'ngx-bootstrap/modal';
import { Router } from '@angular/router'
import { DoCheck } from '@angular/core';
declare var window: any;
@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit, DoCheck {
  page = 0;
  pageSize = 5;
  preSize;

  formValue: FormGroup;
  title: any;
  saveModal: any;
  updateModal: any;
  employees: Employee;
  employeeList: Employee[];
  list: Array<Employee> = [];
  file:File=null;
  message:string;
  // employeeValue:Employee={
  //   id:0,
  //   salary:0,
  //   name:"",
  //   address:"",
  //   phone:"",
  //   emailId:"",
  //   profile:"",
  //   department:""
  // }
 
  constructor(private employeeService: EmployeeServiceService, private formBuilder: FormBuilder, private router: Router) {
   this.formValue = new FormGroup
      ({
        firstName: new FormControl(''),
        lastName: new FormControl(''),
        phone_no: new FormControl(''),
        email: new FormControl(''),
        profile:new FormControl(''),
        work:new FormControl(''),
        department:new FormControl(''),
        address: 
          new FormGroup({
            hno: new FormControl(''),
            city: new FormControl(''),
            state: new FormControl(''),
            pincode: new FormControl('')
          }),
   
          quelification: 
          new FormGroup({
            passingYear: new FormControl(''),
            highSchool: new FormControl(''),
            diploma: new FormControl(''),
            degree: new FormControl('')
          }),
          UploadFile:
          new FormGroup({
            file:new FormControl('')
          })

      })
  }
  @ViewChild("exampleModal") childModal: ModalDirective

  //  get firstName() {
  //   // return this.formValue.get('firstName').set;
  // }


  ngOnInit(): void {
    this.getEmployee();
    this.saveModal = new window.bootstrap.Modal(
      document.getElementById("exampleModal")
    );
  }
  ngDoCheck(): void {
    // this.openSaveModal() 
  }

  saves = true;
  update = true;
  openSaveModal() {

    // if( this.employeeService.childModal==true){

    this.update = false;
    this.saves = true;
    this.title = "Add Employee";
    // this.childModal.show();
    this.saveModal.show();

  }
  asd: any;
  openUpdateModal(a: number) {
    // if(modal=="saveModal")
    this.saves = false;
    this.update = true;
    this.asd = a;
    this.title = "Update Employee";
    this.saveModal.show();
    this.employeeService.employeeGetbyId(a).subscribe(data => {
      console.log(data);
      this.formValue.get('id').setValue(data.id);
      this.formValue.get('firstName').setValue(data.firstName);
      this.formValue.get('lastName').setValue(data.lastName);
      this.formValue.get('firstName').setValue(data.firstName);
      this.formValue.get('phone_no').setValue(data.phone_no);
      this.formValue.get('address').setValue(data.address);
      this.formValue.get('email').setValue(data.email);
    })
    // else

  }

  closeSaveModal() {
    // if(modal=="saveModal")
    this.employeeService.childModal = false;
    // this.childModal.show();
    // this.saveModal.show();
    this.saveModal.hide();


    // else
  }


  saveEmp(data: any) {
    this.saveModal.show();
    this.employeeService.createEmployee(data).subscribe(da => {

      alert("Save Sucussfully..");
      console.log(da);
      
      this.saveModal.hide();
      // window.location.reload();
    })
  }
  getEmployee() {
    this.employeeService.getEmployeeList(this.page, this.pageSize).subscribe(data => {
      this.list = data.content;

    })
  }

  nextPage() {
    console.log(this.page);

    if (this.page <= 0 || this.page >= 0) {
      this.preSize = this.page;
      this.page++;
      this.getEmployee();
    }
  }

  previousPage() {
    console.log(this.page)
    if (this.page >= 0) {

      this.getEmployee()
      this.page--;

    }

  }

  deleteEmployee(id: any) {
    if (confirm("Do you want to delete"))
      this.employeeService.deleteEmployee(id).subscribe(data => {
        data = this.employees;
        window.location.reload();
      })
  }
  updateEmployee(id: any, employee: Employee) {
    this.employeeService.updateEmployee(id, employee).subscribe(data => {
      data = this.employees;
      alert("update Successfully");
    })
  }

  onChange(event) {
    this.file = event.target.files[0];
}
  uploadFile(){

  this.employeeService.fileUplaod(this.file).subscribe(data=>{

})

  }

  actionValue : any;
  getAction(actionValue:any){
    console.log(actionValue);
    this.actionValue = actionValue;
    
  }
  getOnSubmit(fc:any){
    console.log(fc.value);
    
  }
}
