import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Procedure } from '../Domain/procedure';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('user:passwordUser')
  })
};

@Injectable({
  providedIn: 'root'
})
export class ProcedureService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getProcedures(): Observable<Procedure[]> {
    return this.http.get<Procedure[]>(`${this.apiServerUrl}/procedure/all`, httpOptions)
  }

  public updateProcedure(procedure: Procedure): Observable<Procedure> {
    return this.http.post<Procedure>(`${this.apiServerUrl}/procedure/save`, procedure, httpOptions)
  }

}

