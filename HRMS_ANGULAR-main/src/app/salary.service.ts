import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import { Observable} from 'rxjs';
import {Salary} from './employee'

@Injectable({
  providedIn: 'root'
})
export class SalaryService {
  private baseUrl="/hrms"
  constructor(private httpClient:HttpClient) { }

  getSalary():Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getSalary`);
  }
  saveSalary(salary:any):Observable<any>{
    return this.httpClient.post<any>(`${this.baseUrl}/addSalary`,salary);
  }

  getSalaryById(salaryId:number):Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/salaryGetById/${salaryId}`)
  }

  updateSalary(salaryId:number,salary:Salary):Observable<any>{
    return this.httpClient.put<any>(`${this.baseUrl}/updateSalary/${salaryId}`,salary)
  }
  deleteSalary(salaryId:number):Observable<any>{
    return this.httpClient.delete<any>(`${this.baseUrl}/deleteSalaryById/${salaryId}`);
  }
}
