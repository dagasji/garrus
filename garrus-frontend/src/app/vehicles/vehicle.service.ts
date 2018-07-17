import { Entry } from './entry';
import {Injectable} from '@angular/core';
import {Vehicle} from './vehicle';
import { HttpParams } from '@angular/common/http';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class VehicleService {

  private vehiclesURL = 'http://localhost:8080/';


  constructor(
    private http: HttpClient) {}

  getVehicles(): Observable<Vehicle[]> {
    const url = `${this.vehiclesURL}/vehicle/listAll`;
    return this.http.get<Vehicle[]>(url).pipe(
      tap(heroes => this.log(`fetched heroes ${url}`)),
      catchError(this.handleError('getHeroes', []))
    );
    //    this.messageService.add('VehicleService: fetched vehicles {}');
  }
  
  getAvaliableVehicles(start: string, end: string): Observable<Vehicle[]> {
    const url = `${this.vehiclesURL}/vehicle/listAvaliable?start=${start}&end=${end}`;
    return this.http.get<Vehicle[]>(url);
  }

  getVehicle(plate: string): Observable<Vehicle> {
    const url = `${this.vehiclesURL}/vehicle/${plate}`;
    return this.http.get<Vehicle>(url);

    //  this.messageService.add(`VehicleService: fetched vechicle plate=${plate}`);
  }

  push(vehicle: Vehicle): void {
    const url = `${this.vehiclesURL}/vehicle`;
    this.http.post<Vehicle>(url, vehicle, httpOptions).pipe(
      tap(heroes => this.log(`saved plate=${vehicle.plate}`)),
      catchError(this.handleError('push', []))
    ).subscribe(r => {});
  }

  delete(plate: string): Observable<any[] | Vehicle> {
    const url = `${this.vehiclesURL}/vehicle/${plate}`;
    return this.http.delete<Vehicle>(url).pipe(
      tap(heroes => this.log(`delete plate=${plate}`)),
      catchError(this.handleError('push', []))
    );
  }
  
  loadEntry(plate: string): Observable<Entry[]> {
    const url = `${this.vehiclesURL}/vehicle/entry/${plate}`;
    return this.http.get<Entry[]>(url).pipe(
      tap(heroes => this.log(`get entry plate=${plate}`)),
      catchError(this.handleError('get', []))
    );
  }
  
   deleteEntry(entry: Entry): Observable<any[] | Entry> {
    const url = `${this.vehiclesURL}/vehicle/entry/${entry.id}`;
    return this.http.delete<Entry>(url).pipe(
      tap(heroes => this.log(`delete entry id=${entry.id}`)),
      catchError(this.handleError('push', []))
    );
  }
  
   pushEntry(entry: Entry): Observable<any[] | Entry> {
    const url = `${this.vehiclesURL}/vehicle/entry`;
    return this.http.post<Entry>(url, entry, httpOptions).pipe(
      tap(heroes => this.log(`saved entry entry=${entry}`)),
      catchError(this.handleError('push', []))
    );
  }



  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {

      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead

      // TODO: better job of transforming error for user consumption
      this.log(`${operation} failed: ${error.message}`);

      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
  }

  /** Log a HeroService message with the MessageService */
  private log(message: string) {
  }
}
