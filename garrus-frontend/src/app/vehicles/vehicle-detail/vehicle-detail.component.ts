import {Component, OnInit, Input} from '@angular/core';

import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

import {VehicleService} from '../vehicle.service';
import {DriverService} from '../driver.service';
import {Vehicle} from '../vehicle';
import {Driver} from '../driver';

@Component({
  selector: 'app-vehicle-detail',
  templateUrl: './vehicle-detail.component.html',
  styleUrls: ['./vehicle-detail.component.css']
})
export class VehicleDetailComponent implements OnInit {

  @Input() vehicle: Vehicle;
  drivers: Driver[];
  disabledPlate = true;
  
  constructor(
    private route: ActivatedRoute,
    private heroService: VehicleService,
    private driverService: DriverService,
    private location: Location) {}

  ngOnInit() {
    if (this.route.snapshot.paramMap.get('plate') != null) {
      this.getVehicle(this.route.snapshot.paramMap.get('plate'));
    } else {
      this.disabledPlate = false;
      this.vehicle = new Vehicle;
    }
    this.driverService.getDrivers().subscribe(drivers => this.drivers = drivers);
  }

  compareFn(c1: Driver, c2: Driver): boolean {
    return c1 && c2 ? c1.rut === c2.rut : c1 === c2;
  }

  getVehicle(plate: string): void {
    this.heroService.getVehicle(plate).subscribe(vehicle => this.vehicle = vehicle);
  }

  save(): void {
    this.heroService.push(this.vehicle);
    alert("Cambios guardados con éxito.");
    if (this.disabledPlate === false) {
      this.disabledPlate = true;
    }
  }
  goBack(): void {
    this.location.back();
  }
}
