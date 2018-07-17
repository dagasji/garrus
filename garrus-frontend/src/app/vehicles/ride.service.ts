import { Entry } from './entry';
import { Ride } from './ride';
import {Injectable} from '@angular/core';
import {Vehicle} from './vehicle';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class RideService {

  private URL = 'http://localhost:8080/ride/';


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
  
  delete(id: string): Observable<any[] | Ride> {
    const url = `${this.URL}${id}`;
    return this.http.delete<Ride>(url);
  }

}
