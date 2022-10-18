import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Patient } from '../Domain/patient';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:passwordAdmin')
  })
};

@Injectable({
  providedIn: 'root'
})
export class PatientService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getPatients(): Observable<Patient[]> {
    return this.http.get<Patient[]>(`${this.apiServerUrl}/patient/all`, httpOptions)
  }

  public addPatient(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(`${this.apiServerUrl}/patient/save`, patient)
  }

  public updatePatient(patient: Patient): Observable<Patient> {
    return this.http.post<Patient>(`${this.apiServerUrl}/patient/save`, patient)
  }

  public deletePatient(patientId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/patient/delete/${patientId}`)
  }

}

