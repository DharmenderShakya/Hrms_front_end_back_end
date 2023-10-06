import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EmployeeDetailsComponent } from './employee-details/employee-details.component';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { NgbDropdownModule, NgbModule, } from '@ng-bootstrap/ng-bootstrap';
import { LeaveComponent } from './leave/leave.component';
import { BsDropdownModule} from 'ngx-bootstrap';
import { SalaryComponent } from './salary/salary.component';
import { ProjectComponent } from './project/project.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { ModalModule } from 'ngx-bootstrap/modal';
import {BsDatepickerModule} from 'ngx-bootstrap';
import { AddressComponent } from './address/address.component';
import { QuelificationComponent } from './quelification/quelification.component';
import { EmployeeDetailsPageComponent } from './employee-details-page/employee-details-page.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { EmployeeFormComponent } from './employee-form/employee-form.component';
import { LeaveFormComponent } from './leave-form/leave-form.component';
import { SalaryFormComponent } from './salary-form/salary-form.component'
import { AuthGuard } from 'src/app/auth.guard';
import { NavbarComponent } from './navbar/navbar.component';
import { DeshboardComponent } from './deshboard/deshboard.component';
import { ToastrModule } from 'ngx-toastr';
import { authInterceptorProviders } from './auth.interceptor';
// import { DataService} from './employee-service.service';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeDetailsComponent,
    LoginComponent,
    LeaveComponent,
    SalaryComponent,
    ProjectComponent,
    AddressComponent,
    QuelificationComponent,
    EmployeeDetailsPageComponent,
    SidebarComponent,
    EmployeeFormComponent,
    LeaveFormComponent,
    SalaryFormComponent,
    NavbarComponent,
    DeshboardComponent,
  ],
  imports: [
    BsDatepickerModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgbModule,
    NgbDropdownModule,
    BsDropdownModule.forRoot(),
    NgxPaginationModule,
    ModalModule.forRoot(),
    ToastrModule.forRoot({
      positionClass:'toaster-postition',
      preventDuplicates: true,      // Prevent duplicate messages
      resetTimeoutOnDuplicate: true
    }),
    FormsModule
    ],
  providers: [
    authInterceptorProviders
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
