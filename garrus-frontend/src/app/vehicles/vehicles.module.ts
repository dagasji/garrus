import { DriverService } from './driver.service';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

import { RouterModule } from '@angular/router';
import { VehicleTableComponent } from './vehicle-table/vehicle-table.component';
import { VehicleDetailComponent } from './vehicle-detail/vehicle-detail.component';
import { VehicleHistoryComponent } from './vehicle-history/vehicle-history.component';
import { VehicleService } from './vehicle.service';

import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule } from '@angular/material/button';
import { MatMenuModule } from '@angular/material/menu';
import { MatTableModule } from '@angular/material/table';
import { MatInputModule } from '@angular/material/input';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatSelectModule } from '@angular/material/select';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatIconModule } from '@angular/material/icon';
import { MatDialogModule } from '@angular/material/dialog';
import { CustomersRoutingModule } from './vehicles-routing.module';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { VehiclesDashboardComponent } from './vehicles-dashboard/vehicles-dashboard.component';
import { NavigationComponent } from './navigation/navigation.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { DriverTableComponent } from './driver-table/driver-table.component';
import { VehicleListComponent } from './vehicle-list/vehicle-list.component';
import { DriverDetailComponent } from './driver-detail/driver-detail.component';
import { DriverListComponent } from "./driver-list/driver-list.component";

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    RouterModule,
    CustomersRoutingModule,
    MatInputModule,
    MatButtonModule,
    MatDatepickerModule,
    MatMenuModule,
    MatTableModule,
    MatSelectModule,
    MatGridListModule,
    MatIconModule,
    MatDialogModule,
    MatSortModule,
    MatPaginatorModule,
    MatCheckboxModule,
  ],
  exports: [VehicleTableComponent, VehicleDetailComponent, VehicleHistoryComponent, VehiclesDashboardComponent],
  declarations: [VehicleTableComponent, VehicleDetailComponent, VehicleHistoryComponent, VehiclesDashboardComponent, NavigationComponent, VehicleComponent, DriverTableComponent, VehicleListComponent, DriverListComponent, DriverDetailComponent],
  providers: [VehicleService, DriverService],
})
export class VehiclesModule { }
