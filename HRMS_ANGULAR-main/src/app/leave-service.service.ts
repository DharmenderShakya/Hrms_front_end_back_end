import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Leave} from './employee';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LeaveServiceService {

  private baseUrl="/hrms"

  constructor(private httpClient:HttpClient) { }

  getLeave():Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getLeaveDetails`);
  }
  saveLeave(leave:any):Observable<any>{
    return this.httpClient.post<any>(`${this.baseUrl}/saveleave`,leave);
  }
  getLeaveById(leaveId:any):Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getByLeaveId/${leaveId}`);
  }
 updateLeave(leaveId:number,leave:Leave):Observable<any>{

  return this.httpClient.put<any>(`${this.baseUrl}/updateLeave/${leaveId}`,leave);

 }
 deleteLeave(leaveId:number):Observable<any>{
  return  this.httpClient.delete<any>(`${this.baseUrl}/deleteByLeaveId/${leaveId}`);
 }

//  addLeave(empId:number,leave:any):Observable<any>{
//   return this.httpClient.post<any>(`${this.baseUrl}/addleave/${empId}`,leave)
//  }

uploadFile(file):Observable<any>{
  
  let formData=new FormData();
  formData.append("image",file,file.filename);
  return this.httpClient.post<any>(`${this.baseUrl}/uploadFile`,formData);
}


}
