import {NavigationComponent} from './navigation/navigation.component';
import {RidesDetailComponent} from './rides-detail/rides-detail.component';
import {RidesListComponent} from './rides-list/rides-list.component';
import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';

import {VehicleTableComponent} from './vehicle-table/vehicle-table.component';
import {VehicleDetailComponent} from './vehicle-detail/vehicle-detail.component';
import {VehicleHistoryComponent} from './vehicle-history/vehicle-history.component'
import {VehiclesDashboardComponent} from './vehicles-dashboard/vehicles-dashboard.component';
import {RideDashboardComponent} from './ride-dashboard/ride-dashboard.component';


const routes: Routes = [
  {
    path: '',
    component: NavigationComponent,
    children: [
      {
        path: 'dashboard',
        component: VehiclesDashboardComponent,
      },
      {
        path: 'vehicles',
        //        component: VehicleTableComponent,
        children: [{
          path: '',
          component: VehicleTableComponent,
        },
        {
          path: 'detail/:plate',
          component: VehicleDetailComponent
        },
        {
          path: 'newVehicle',
          component: VehicleDetailComponent
        }
        ]
      }, {
        path: 'ride',
        children: [{
          path: '',
          component: RideDashboardComponent,
        }, {
          path: ':id',
          component: RidesDetailComponent,
        }, {
          path: 'newRide',
          component: RidesDetailComponent,
        }]
      }
    ]
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CustomersRoutingModule {}