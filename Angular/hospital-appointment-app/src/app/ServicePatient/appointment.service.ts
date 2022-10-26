import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Appointment } from '../Domain/appointment';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('user:passwordUser')
  })
};

@Injectable({
  providedIn: 'root'
})
export class AppointmentService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getAppointments(): Observable<Appointment[]> {
    return this.http.get<Appointment[]>(`${this.apiServerUrl}/appointment/all`, httpOptions)
  }

  public updateAppointment(appointment: Appointment): Observable<Appointment> {
    return this.http.post<Appointment>(`${this.apiServerUrl}/appointment/save`, appointment, httpOptions)
  }

}

