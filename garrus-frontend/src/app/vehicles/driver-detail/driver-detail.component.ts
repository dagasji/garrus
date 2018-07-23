import {Component, OnInit, Input} from '@angular/core';

import {ActivatedRoute} from '@angular/router';
import {Location} from '@angular/common';

import {DriverService} from '../driver.service';
import {Driver} from '../driver';
import { Leave } from "../leave";
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-driver-detail',
  templateUrl: './driver-detail.component.html',
  styleUrls: ['./driver-detail.component.css']
})
export class DriverDetailComponent implements OnInit {

  @Input() driver: Driver;
  disableRut = true;
  
  constructor(
    private route: ActivatedRoute,
    private driverService: DriverService,
    private toastr: ToastrService) {}

  ngOnInit() {
    if (this.route.snapshot.paramMap.get('rut') != null) {
      this.getDriver(this.route.snapshot.paramMap.get('rut'));
    } else {
      this.disableRut = false;
      this.driver = new Driver();
    }
  }

  getDriver(rut: string): void {
    this.driverService.getDriver(rut).subscribe(res => this.driver = res);
  }

  save(): void {
    this.driverService.push(this.driver);
    this.toastr.success("Datos guardados con éxito.");
    if (this.disableRut === false) {
      this.disableRut = true;
    }
  }

}
