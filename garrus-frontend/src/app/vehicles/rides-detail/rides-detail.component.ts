import { Driver } from '../driver';
import { DriverService } from '../driver.service';
import { Ride } from '../ride';
import { RideService } from '../ride.service';
import { Vehicle } from '../vehicle';
import { VehicleService } from '../vehicle.service';
import { Component, OnInit, Input } from '@angular/core';
import { Observable, Subject } from 'rxjs';
import { ToastrService } from 'ngx-toastr';

import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';
import { NotificationsComponent } from '../../notifications/notifications.component';

@Component({
  selector: 'app-rides-detail',
  templateUrl: './rides-detail.component.html',
  styleUrls: ['./rides-detail.component.scss']
})
export class RidesDetailComponent implements OnInit {

  @Input() ride: Ride = new Ride();
  dateStart: string;
  dateEnd: string;
  hourStart: string;
  hourEnd: string;
  drivers: Driver[];
  vehicles: Vehicle[];
  tittle = 'Nuevo viaje';
  mySubject = new Subject();
  newRide = true;

  constructor(private rideService: RideService, private vehicleService: VehicleService, private driverService: DriverService,
    private route: ActivatedRoute, private toastr: ToastrService) {
    this.mySubject
      .debounceTime(500)
      .subscribe(val => {
        this.reloadData();
      });
  }

  ngOnInit() {
    if (this.route.snapshot.paramMap.get('id')) {
      this.tittle = 'Detalle viaje'
      this.rideService.getById(this.route.snapshot.paramMap.get('id')).subscribe(res => {
        this.ride = res;
        this.newRide = false;
        this.dateStart = this.ride.start.split('T')[0];
        this.hourStart = this.ride.start.split('T')[1];
        this.dateEnd = this.ride.end.split('T')[0];
        this.hourEnd = this.ride.end.split('T')[1];
        this.drivers.push(res.chofer);
        this.vehicles.push(res.vehicle);
      });
    }
  }

  dateStartChange(event) {
    this.dateStart = event;
    this.mySubject.next(event);
  }

  hourStartChange(event) {
    this.hourStart = event;
    this.mySubject.next(event);
  }

  dateEndChange(event) {
    this.dateEnd = event;
    this.mySubject.next(event);
  }

  hourEndChange(event) {
    this.hourEnd = event;
    this.mySubject.next(event);
  }

  reloadData() {
    this.ride.start = `${this.dateStart}T${this.hourStart}:00`;
    this.ride.end = `${this.dateEnd}T${this.hourEnd}:00`;

    if (this.ride.start.length === 19 && this.ride.end.length === 19) {

      if (Date.parse(this.ride.end) <= Date.parse(this.ride.start)) {
        this.toastr.warning("La fecha y hora de llegada debe ser superior a la de inicio.");
      } else {
        this.driverService.getAvaliable(this.ride.start, this.ride.end).subscribe(res => this.drivers = res);
        if (this.drivers == null || this.drivers.length === 0) {
          this.toastr.warning("No hay conductores disponibles a esas horas");
        }
        this.vehicleService.getAvaliableVehicles(this.ride.start, this.ride.end).subscribe(res => this.vehicles = res);
        if (this.vehicles == null || this.vehicles.length === 0) {
          this.toastr.warning("No hay vehiculos disponibles a esas horas");
        }
      }
    }
  }

  compareDriver(c1: Driver, c2: Driver): boolean {
    return c1 && c2 ? c1.rut === c2.rut : c1 === c2;
  }


  compareVehicle(c1: Vehicle, c2: Vehicle): boolean {
    return c1 && c2 ? c1.plate === c2.plate : c1 === c2;
  }

  save() {
    this.rideService.push(this.ride).subscribe(res => {
      this.toastr.success("Datos guardados con éxito.");
      this.ride = new Ride();
      this.drivers = null;
      this.vehicles = null;
      this.dateEnd = null;
      this.dateStart = null;
      this.hourEnd = null;
      this.hourStart = null;
    });
  }

}
