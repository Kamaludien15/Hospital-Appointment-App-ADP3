import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Gender } from '../Domain/gender';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:passwordAdmin')
  })
};

@Injectable({
  providedIn: 'root'
})

export class GenderService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getGenders(): Observable<Gender[]> {
    return this.http.get<Gender[]>(`${this.apiServerUrl}/gender/all`, httpOptions)
  }

  public addGender(gender: Gender): Observable<Gender> {
    return this.http.post<Gender>(`${this.apiServerUrl}/gender/save`, gender, httpOptions)
  }

  public updateGender(gender: Gender): Observable<Gender> {
    return this.http.post<Gender>(`${this.apiServerUrl}/gender/save`, gender, httpOptions)
  }

  public deleteGender(genderId?: String): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/gender/delete/${genderId}`, httpOptions)
  }

}
