import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Employee} from './employee';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})

export class EmployeeServiceService {

  childModal:Boolean;

  private baseUrl="/hrms"

  constructor(private httpClient:HttpClient) { }

  getEmployeeList(page,size):Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getEmployee?page=${page}&size=${size}`);
  }
  createEmployee(employee:any):Observable<any>{
    return this.httpClient.post<any>(`${this.baseUrl}/addEmployee`,employee);
  }
  employeeGetbyId(id:number):Observable<Employee>{
    return this.httpClient.get<Employee>(`${this.baseUrl}/getById/${id}`);
  }
  updateEmployee(id:number,employee:Employee):Observable<any>{
    return this.httpClient.put<Employee>(`${this.baseUrl}/updateEmployee/${id}`,employee);
  }
  deleteEmployee(id:number):Observable<any>{
    return this.httpClient.delete(`${this.baseUrl}/deleteEmployee/${id}`);
  }

  getEmployeeDetails():Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getEmployeeDetails`);
  }
fileUplaod(file):Observable<any>{

  const formData = new FormData(); 
        
  // Store form name as "file" with file data
  formData.append("image", file, file.filename);
  return this.httpClient.post<any>(`${this.baseUrl}/upload`,formData)

}

}
