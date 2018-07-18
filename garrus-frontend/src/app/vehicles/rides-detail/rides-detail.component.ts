import {Driver} from '../driver';
import {DriverService} from '../driver.service';
import {Ride} from '../ride';
import {RideService} from '../ride.service';
import {Vehicle} from '../vehicle';
import {VehicleService} from '../vehicle.service';
import {Component, OnInit, Input} from '@angular/core';

import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

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

  constructor(private rideService: RideService, private vehicleService: VehicleService, private driverService: DriverService,
    private route: ActivatedRoute, ) {}

  ngOnInit() {
    if (this.route.snapshot.paramMap.get('id')) {
      this.tittle = 'Detalle viaje'
      this.rideService.getById(this.route.snapshot.paramMap.get('id')).subscribe(res => this.ride = res);
    }
  }

  dateStartChange(event) {
    this.dateStart = event;
    this.reloadData();
  }

  hourStartChange(event) {
    this.hourStart = event;
    this.reloadData();
  }

  dateEndChange(event) {
    this.dateEnd = event;
    this.reloadData();
  }

  hourEndChange(event) {
    this.hourEnd = event;
    this.reloadData();
  }
  
  reloadData() {
    this.ride.start  = `${this.dateStart}T${this.hourStart}:00`;
    this.ride.end  = `${this.dateEnd}T${this.hourEnd}:00`;
    if (this.ride.start.length === 19 && this.ride.end.length === 19) {
      this.driverService.getAvaliable(this.ride.start, this.ride.end).subscribe(res => this.drivers = res);
      this.vehicleService.getAvaliableVehicles(this.ride.start, this.ride.end).subscribe(res => this.vehicles = res);
    }
  }

  compareDriver(c1: Driver, c2: Driver): boolean {
    return c1 && c2 ? c1.rut === c2.rut : c1 === c2;
  }


  compareVehicle(c1: Vehicle, c2: Vehicle): boolean {
    return c1 && c2 ? c1.plate === c2.plate : c1 === c2;
  }

  save() {
    this.rideService.push(this.ride).subscribe(res => {alert('Viaje guardado con éxito')});
  }

}
