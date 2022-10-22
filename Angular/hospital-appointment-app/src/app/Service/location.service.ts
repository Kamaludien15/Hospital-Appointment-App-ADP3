import { Injectable } from '@angular/core';
import { HttpClient} from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

import { HttpHeaders } from '@angular/common/http';
import { Location } from '../Domain/location';

const httpOptions = {
  headers: new HttpHeaders({
    'Content-Type':  'application/json',
    'Authorization': 'Basic ' + btoa('admin:passwordAdmin')
  })
};

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getLocations(): Observable<Location[]> {
    return this.http.get<Location[]>(`${this.apiServerUrl}/location/all`, httpOptions)
  }

  public addLocation(location: Location): Observable<Location> {
    return this.http.post<Location>(`${this.apiServerUrl}/location/save`, location)
  }

  public updateLocation(location: Location): Observable<Location> {
    return this.http.post<Location>(`${this.apiServerUrl}/location/save`, location)
  }

  public deleteLocation(locationId: string): Observable<void> {
    return this.http.delete<void>(`${this.apiServerUrl}/location/delete/${locationId}`)
  }

}

