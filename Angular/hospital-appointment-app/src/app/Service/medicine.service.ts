import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Medicine } from '../Domain/medicine';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:passwordAdmin')
  })
};

@Injectable({
  providedIn: 'root'
})
export class MedicineService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getMedicine(): Observable<Medicine[]> {
    return this.http.get<Medicine[]>(`${this.apiServerUrl}/medicine/all`, httpOptions)
  }

  public addMedicine(medicine: Medicine): Observable<Medicine> {
    return this.http.post<Medicine>(`${this.apiServerUrl}/medicine/save`, medicine, httpOptions)
  }

  public updateMedicine(medicine: Medicine): Observable<Medicine> {
    return this.http.post<Medicine>(`${this.apiServerUrl}/medicine/save`, medicine, httpOptions)
  }

  public deleteMedicine(medicineID?: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/medicine/delete/${medicineID}`, httpOptions)
  }

}

