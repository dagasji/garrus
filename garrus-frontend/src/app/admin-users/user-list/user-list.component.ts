import { User } from '../../user-profile/user';
import {UserService} from '../../user-profile/user.service';
import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource, MatPaginator} from '@angular/material';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.scss']
})
export class UserListComponent implements OnInit {

  dataSource = new MatTableDataSource();
  displayedColumns = ['username', 'name', 'actions'];

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.load();
  }

  load() {
    this.userService.getAll()
      .subscribe(result => {
        this.dataSource.data = result as User[];
      });
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }

}
