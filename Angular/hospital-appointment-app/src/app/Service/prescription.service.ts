import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Prescription } from '../Domain/prescription';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:passwordAdmin')
  })
};

@Injectable({
  providedIn: 'root'
})
export class PrescriptionService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getPrescriptions(): Observable<Prescription[]> {
    return this.http.get<Prescription[]>(`${this.apiServerUrl}/prescription/all`, httpOptions)
  }

  public addPrescription(prescription: Prescription): Observable<Prescription> {
    return this.http.post<Prescription>(`${this.apiServerUrl}/prescription/save`, prescription, httpOptions)
  }

  public updatePrescription(prescription: Prescription): Observable<Prescription> {
    return this.http.post<Prescription>(`${this.apiServerUrl}/prescription/save`, prescription, httpOptions)
  }

  public deletePrescription(scriptRef?: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/prescription/delete/${scriptRef}`, httpOptions)
  }

}

