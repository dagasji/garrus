import { UserService } from '../user-profile/user.service';
import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';

import {AdminUsersRoutingModule} from './admin-users-routing.module';
import {UserListComponent} from './user-list/user-list.component';
import {UserDetailComponent} from './user-detail/user-detail.component';
import { FormsModule } from '@angular/forms';

import {MatButtonModule} from '@angular/material/button';
import {MatMenuModule} from '@angular/material/menu';
import {MatTableModule} from '@angular/material/table';
import {MatInputModule} from '@angular/material/input';
import {MatDatepickerModule} from '@angular/material/datepicker';
import {MatSelectModule} from '@angular/material/select';
import {MatGridListModule} from '@angular/material/grid-list';
import {MatIconModule} from '@angular/material/icon';
import {MatDialogModule} from '@angular/material/dialog';
import {MatPaginatorModule} from '@angular/material/paginator';
import {MatSortModule} from '@angular/material/sort';
import { RouterModule } from '@angular/router';

@NgModule({
  imports: [
    CommonModule, 
    FormsModule,
    RouterModule,
    AdminUsersRoutingModule,
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
    MatPaginatorModule
  ],
  exports: [UserListComponent],
  providers:[UserService],
  declarations: [UserListComponent, UserDetailComponent]
})
export class AdminUsersModule {}
