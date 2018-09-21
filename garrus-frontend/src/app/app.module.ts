import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app.routing';
import { ComponentsModule } from './components/components.module';

import { AppComponent } from './app.component';
import { JwtModule } from '@auth0/angular-jwt';
import { AuthGuard } from './auth/auth-guard.service';
import { AuthService } from './auth/auth.service';

import { AdminLayoutComponent } from './layouts/admin-layout/admin-layout.component';
import {VehiclesModule} from './vehicles/vehicles.module';
import { LoginComponent } from './login/login.component'
import { AdminUsersModule } from './admin-users/admin-users.module';
import { ToastrModule } from 'ngx-toastr';
import { LoadingPageModule } from 'angular-loading-page'; 


import { MatButtonModule } from '@angular/material/button';
import { MatInputModule } from '@angular/material/input';


export function tokenGetter() {
  return localStorage.getItem('token');
}

@NgModule({
  imports: [
    BrowserAnimationsModule,
    FormsModule,
    HttpClientModule,
    HttpModule,
    ComponentsModule,
    RouterModule,
    ToastrModule.forRoot({
      timeOut: 5000,
      positionClass: 'toast-top-right',
      preventDuplicates: true,
    }),
    LoadingPageModule,
    AppRoutingModule,
    JwtModule.forRoot({
      config: {
        tokenGetter: tokenGetter,
        whitelistedDomains: ['localhost:8080'],
        blacklistedRoutes: ['localhost:8080/public/user/login']
      }
    }),
    MatButtonModule,
    MatInputModule,
    VehiclesModule,
    AdminUsersModule
//    AgmCoreModule.forRoot({
//      apiKey: 'YOUR_GOOGLE_MAPS_API_KEY'
//    }),
  ],
  declarations: [
    AppComponent,
    AdminLayoutComponent,
    LoginComponent,
  ],
  providers: [AuthGuard,AuthService],
  bootstrap: [AppComponent]
})
export class AppModule { }
