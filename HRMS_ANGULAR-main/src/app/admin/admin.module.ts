import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router, RouterModule, Routes } from '@angular/router';
import { EmployeeDetailsComponent } from '../employee-details/employee-details.component';
import { EmployeeFormComponent } from '../employee-form/employee-form.component';
import { LeaveFormComponent } from '../leave-form/leave-form.component';
import { SalaryFormComponent } from '../salary-form/salary-form.component';
import { LeaveComponent } from '../leave/leave.component';
import { ProjectComponent } from '../project/project.component';
import { SalaryComponent } from '../salary/salary.component';
import { EmployeeDetailsPageComponent } from '../employee-details-page/employee-details-page.component';
import { DeshboardComponent } from '../deshboard/deshboard.component';
import { LoginAuthGurd } from '../auth.guard';
 
const routes:Routes = [
  {path:'',component:DeshboardComponent,canActivate: [LoginAuthGurd],
  children:[
  {path:'employee',component:EmployeeDetailsComponent},
  {path:'addemployee',component:EmployeeFormComponent},
  {path:'addleave',component:LeaveFormComponent},
  {path:'addsalary',component:SalaryFormComponent},
  {path:'leave',component:LeaveComponent},
  {path:'project',component:ProjectComponent},
  {path:'salary', component:SalaryComponent},
  {path:'details/:id',component:EmployeeDetailsPageComponent},
  { path: '', redirectTo: '/deshboard/employee', pathMatch: 'full' },
  ],
},
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
  declarations: [],
})
export class AdminModule { }
