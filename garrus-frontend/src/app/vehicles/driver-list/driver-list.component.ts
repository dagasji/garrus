import {Component, OnInit, ViewChild, Input} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Driver} from '../driver';
import {DriverService} from '../driver.service';

@Component({
  selector: 'app-driver-list',
  templateUrl: './driver-list.component.html',
  styleUrls: ['./driver-list.component.scss']
})
export class DriverListComponent implements OnInit {

  @Input() showFilter = false;
  @Input() showActions = false;
  @Input() display = 'all';
  dataSource = new MatTableDataSource();


  displayedColumns = ['rut', 'name'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private driverService: DriverService) {}

  ngOnInit() {
    this.load();
    if (this.showActions) {
      this.displayedColumns.push('actions');
    }
  }

  load() {
    switch (this.display) {
      case 'avaliable': {
        const now = new Date();
        this.driverService.getAvaliable(now.toJSON(),now.toJSON())
        .subscribe(result => {
          this.dataSource.data = result as Driver[];
        });
        break;
      }
      default: {
        this.driverService.getDrivers()
        .subscribe(result => {
          this.dataSource.data = result as Driver[];
        });
      }
    };      
  }
  
onDelete(driver: Driver): void {
  if(confirm("¿Estás seguro de que deseas eliminar el conductor " + driver.name + "?")) {
    this.driverService.delete(driver).subscribe(data => this.load());
  }
}

applyFilter(filterValue: string) {
  filterValue = filterValue.trim(); // Remove whitespace
  filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
  this.dataSource.filter = filterValue;
}

  
}
