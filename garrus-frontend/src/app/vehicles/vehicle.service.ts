import { restBaseUrl } from 'environments/environment';
import { Entry } from './entry';
import {Injectable} from '@angular/core';
import {Vehicle} from './vehicle';
import { Observable, Subject } from 'rxjs';;
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'application/json'})
};


@Injectable()
export class VehicleService {

  private vehiclesURL = restBaseUrl;


  constructor(
    private http: HttpClient) {}

  getVehicles(): Observable<Vehicle[]> {
    const url = `${this.vehiclesURL}/vehicle/listAll`;
    return this.http.get<Vehicle[]>(url);
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
    this.http.post<Vehicle>(url, vehicle, httpOptions).subscribe(r => {});
  }

  delete(plate: string): Observable<any[] | Vehicle> {
    const url = `${this.vehiclesURL}/vehicle/${plate}`;
    return this.http.delete<Vehicle>(url);
  }
  
  loadEntry(plate: string): Observable<Entry[]> {
    const url = `${this.vehiclesURL}/vehicle/entry/${plate}`;
    return this.http.get<Entry[]>(url);
  }
  
   deleteEntry(entry: Entry): Observable<any[] | Entry> {
    const url = `${this.vehiclesURL}/vehicle/entry/${entry.id}`;
    return this.http.delete<Entry>(url);
  }
  
   pushEntry(entry: Entry): Observable<any[] | Entry> {
    const url = `${this.vehiclesURL}/vehicle/entry`;
    return this.http.post<Entry>(url, entry, httpOptions);
  }




}
