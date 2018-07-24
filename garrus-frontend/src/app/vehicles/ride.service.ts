import { Ride } from './ride';
import {Injectable} from '@angular/core';
import { Observable, Subject } from 'rxjs';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import { restBaseUrl } from 'environments/environment';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class RideService {

  private URL = restBaseUrl+'/ride/';


  constructor(
    private http: HttpClient) {}

  getAll(): Observable<Ride[]> {
    const url = `${this.URL}listAll`;
    return this.http.get<Ride[]>(url);
  }
  
  getActive(): Observable<Ride[]> {
    const url = `${this.URL}active`;
    return this.http.get<Ride[]>(url);
  }
  
  getNext(): Observable<Ride[]> {
    const url = `${this.URL}next`;
    return this.http.get<Ride[]>(url);
  }
  
    getPast(): Observable<Ride[]> {
    const url = `${this.URL}past`;
    return this.http.get<Ride[]>(url);
  }

  getById(id: string): Observable<Ride> {
    const url = `${this.URL}${id}`;
    return this.http.get<Ride>(url);
  }

  push(ride: Ride):  Observable<Ride> {
    return this.http.post<Ride>(this.URL, ride, httpOptions);
  }
  
  update(ride: Ride):  Observable<Ride> {
    const url = `${this.URL}${ride.id}`;
    return this.http.put<Ride>(this.URL, ride, httpOptions);
  }
  
  delete(id: number): Observable<any[] | Ride> {
    const url = `${this.URL}${id}`;
    return this.http.delete<Ride>(url);
  }

}
