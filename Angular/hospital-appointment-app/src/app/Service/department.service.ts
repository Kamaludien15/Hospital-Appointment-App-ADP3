import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Department } from '../Domain/department';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:passwordAdmin')
  })
};

@Injectable({
  providedIn: 'root'
})

export class DepartmentService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getDepartments(): Observable<Department[]> {
    return this.http.get<Department[]>(`${this.apiServerUrl}/department/all`, httpOptions)
  }

  public addDepartment(department: Department): Observable<Department> {
    return this.http.post<Department>(`${this.apiServerUrl}/department/save`, department, httpOptions)
  }

  public updateDepartment(department: Department): Observable<Department> {
    return this.http.post<Department>(`${this.apiServerUrl}/department/save`, department, httpOptions)
  }

  public deleteDepartment(departmentId?: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/department/delete/${departmentId}`, httpOptions)
  }

}
