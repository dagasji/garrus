import {AuthGuard} from '../../auth/auth-guard.service';
import {Routes} from '@angular/router';

import {DashboardComponent} from '../../dashboard/dashboard.component';
import {UserProfileComponent} from '../../user-profile/user-profile.component';
export const AdminLayoutRoutes: Routes = [
  {
    path: '',
    canActivate: [AuthGuard],
    canActivateChild: [AuthGuard],
    children: [{
      path: 'vehicles',
      loadChildren: 'app/vehicles/vehicles.module#VehiclesModule'
    }]
  },
  {path: 'dashboard', component: DashboardComponent},
  {path: 'user-profile', component: UserProfileComponent},
  {path: 'user-profile', component: UserProfileComponent},
];
