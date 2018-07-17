import { RidesDetailComponent } from './rides-detail/rides-detail.component';
import { RidesListComponent } from './rides-list/rides-list.component';
import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {VehicleTableComponent} from './vehicle-table/vehicle-table.component';
import {VehicleDetailComponent} from './vehicle-detail/vehicle-detail.component';
import {VehicleHistoryComponent} from './vehicle-history/vehicle-history.component'
import { VehiclesDashboardComponent } from './vehicles-dashboard/vehicles-dashboard.component';

const routes: Routes = [
  {
    path: '',
    component: VehiclesDashboardComponent,
  },{
    path: 'vehicleList',
    component: VehicleTableComponent,
  },{
    path: 'rideList',
    component: RidesListComponent,
  },{
    path: 'rideList/ride/:id',
    component: RidesDetailComponent,
  } ,{
    path: 'ride/:id',
    component: RidesDetailComponent,
  },{
    path: 'newRide',
    component: RidesDetailComponent,
  }, {
    path: 'detail/:plate',
    component: VehicleDetailComponent
  },
  {
    path: 'newVehicle',
    component: VehicleDetailComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule {}