import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Project} from './employee';
import {Observable} from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ProjectService {

  private baseUrl="/hrms"

  constructor(private httpClient:HttpClient) { }

  getProject():Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getProjectDetails`);
  }

  saveProject(project:any):Observable<any>{
    return this.httpClient.post<any>(`${this.baseUrl}/addProject`,project);
  }
  projectGetById(projectId:number):Observable<any>{
    return this.httpClient.get<any>(`${this.baseUrl}/getByProjectId/${projectId}`);
  }

  updateProject(projectId:number,project:any):Observable<any>{
    return this.httpClient.put<any>(`${this.baseUrl}/updateProject/${projectId}`,project);
  }

  deleteProject(projectId:number):Observable<any>{
    return this.httpClient.delete<any>(`${this.baseUrl}/deleteProjectById/${projectId}`);
  }
}
