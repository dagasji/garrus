import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {VehicleTableComponent} from './vehicle-table/vehicle-table.component';
import {VehicleDetailComponent} from './vehicle-detail/vehicle-detail.component';
import {VehicleHistoryComponent} from './vehicle-history/vehicle-history.component'

const routes: Routes = [
  {
    path: '',
    component: VehicleTableComponent,
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