import {Injectable} from '@angular/core';
import {Driver} from './driver';
import {Observable} from 'rxjs/Observable';
import {of} from 'rxjs/observable/of';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class DriverService {

  private driverURL = 'http://localhost:8080/driver/';


  constructor(
    private http: HttpClient) {}

  getDrivers(): Observable<Driver[]> {
    const url = `${this.driverURL}listAll`;
    return this.http.get<Driver[]>(url).pipe(
      tap(heroes => this.log(`fetched heroes ${url}`)),
      catchError(this.handleError('getHeroes', []))
    );
    //    this.messageService.add('DriverService: fetched Drivers {}');
  }

  getDriver(rut: string): Observable<Driver> {
    const url = `${this.driverURL}detail/${rut}`;
    return this.http.get<Driver>(url);
    //  this.messageService.add(`DriverService: fetched vechicle plate=${plate}`);
  }

  push(driver: Driver): void {
    const url = `${this.driverURL}/Driver/save`;
    this.http.post<Driver>(url, driver, httpOptions).pipe(
      tap(heroes => this.log(`saved plate=${driver.rut}`)),
      catchError(this.handleError('push', []))
    ).subscribe(r => {});
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
