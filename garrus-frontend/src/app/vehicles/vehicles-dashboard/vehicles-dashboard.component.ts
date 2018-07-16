import { DriverService } from '../driver.service';
import { RideService } from '../ride.service';
import { VehicleService } from '../vehicle.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-vehicles-dashboard',
  templateUrl: './vehicles-dashboard.component.html',
  styleUrls: ['./vehicles-dashboard.component.scss']
})
export class VehiclesDashboardComponent implements OnInit {

  constructor(
              ) { }

  ngOnInit() {
  
  }

}
