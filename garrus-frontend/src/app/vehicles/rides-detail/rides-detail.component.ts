import { Driver } from '../driver';
import { DriverService } from '../driver.service';
import {Ride} from '../ride';
import { RideService } from '../ride.service';
import { Vehicle } from '../vehicle';
import { VehicleService } from '../vehicle.service';
import {Component, OnInit, Input} from '@angular/core';

import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

@Component({
  selector: 'app-rides-detail',
  templateUrl: './rides-detail.component.html',
  styleUrls: ['./rides-detail.component.scss']
})
export class RidesDetailComponent implements OnInit {

  @Input() ride: Ride;
  drivers: Driver[];
  vehicles: Vehicle[];
  tittle: string;

  constructor(private rideService: RideService, private vehicleService: VehicleService, private driverService: DriverService,
    private route: ActivatedRoute, ) {}

  ngOnInit() {
    if (this.route.snapshot.paramMap.get('id')) {
      this.tittle = 'Detalle viaje'
      this.rideService.getById(this.route.snapshot.paramMap.get('id')).subscribe(res=>this.ride = res);
    }else{
      this.tittle = 'Nuevo viaje'
      this.ride = new Ride();
    }
  }
  
  dateStartChange(event){
    this.ride.start = event;
    this.reloadData();   
  }
  
  dateEndChange(event){
    this.ride.end = event;
    this.reloadData();
  }
  
  reloadData(){
     if ( this.ride.start != null && this.ride.end != null) {
       this.driverService.getAvaliable(this.ride.start,this.ride.end).subscribe(res=>this.drivers = res);
       this.vehicleService.getAvaliableVehicles(this.ride.start,this.ride.end).subscribe(res=>this.vehicles = res);
     }
  }
  
  compareDriver(c1: Driver, c2: Driver): boolean {
    return c1 && c2 ? c1.rut === c2.rut : c1 === c2;
  }
  
  
  compareVehicle(c1: Vehicle, c2: Vehicle): boolean {
    return c1 && c2 ? c1.plate === c2.plate : c1 === c2;
  }
  
  save(){
    
  }

}
