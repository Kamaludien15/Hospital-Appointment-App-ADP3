import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Hospital } from '../Domain/hospital';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('user:passwordUser')
  })
};

@Injectable({
  providedIn: 'root'
})
export class HospitalService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getHospitals(): Observable<Hospital[]> {
    return this.http.get<Hospital[]>(`${this.apiServerUrl}/hospital/all`, httpOptions)
  }

  public updateHospital(hospital: Hospital): Observable<Hospital> {
    return this.http.post<Hospital>(`${this.apiServerUrl}/hospital/save`, hospital)
  }



}

