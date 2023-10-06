import { Component, OnInit } from '@angular/core';
import  {FormGroup,FormBuilder,Validators} from '@angular/forms';
import {Project} from '../employee';
import {ProjectService} from '../project.service';

declare var window:any;
@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  projectModal:any;
  formValue:FormGroup;
  projects:Project;
  list:Array<Project>=[];

  constructor(private projectService:ProjectService,private formBuilder:FormBuilder) { 
    this.formValue=this.formBuilder.group({
      id:['',Validators.required],
      employeeName:['',Validators.required],
      name:['',Validators.required],
      assignDate:['',Validators.required],
      submiDate:['',Validators.required],
      projectDescription:['',Validators.required],
    });
    
  }

  ngOnInit(): void {
    this.getProject();
    this.projectModal=new window.bootstrap.Modal(

      document.getElementById("projectModal")
    );
  }

  saveProject=true;
  update=true;
  title:string;
 openSaveModal(){
this.update=false;
this.title="Add Project";
this.saveProject=true;
  this.projectModal.show();
 }

 projectId:any;
openUpdatemodal(id:any){
  this.saveProject=false;
  this.title="Update Project";
  this.update=true;
  this.projectId=id;
  this.projectModal.show();
  // this.projectService.projectGetById(id).subscribe(data=>{
  //   this.formValue.get("id").setValue(data.id);
  //   this.formValue.get("name").setValue(data.name);
  //   this.formValue.get("assignDate").setValue(data.assignDate);
  //   this.formValue.get("submiDate").setValue(data.submiDate);
  //   this.formValue.get("projectDescription").setValue(data.projectDescription);
  // })
}


 closeModal(){
  this.projectModal.hide();
 }
getProject(){
  this.projectService.getProject().subscribe(data=>{
    this.list=data;
  })
}

addProject(data:any){
  this.projectService.saveProject(data).subscribe(data=>{
    this.projectModal.hide();
    alert("Added successfully");
  })
}
getbyId(id:number){
this.projectService.projectGetById(id).subscribe(data=>{
this.list=data;
})
}
updateProject(id:number,project:Project){
  this.projectService.updateProject(id,project).subscribe(data=>{
  data=this.projects;
  this.projectModal.hide();
  alert("updated successfully");
  })
}
deleteProject(id:number){
  if(confirm("Do you want to deletd"))
  this.projectService.deleteProject(id).subscribe(data=>{
  data=this.projects;
  })
}

}
