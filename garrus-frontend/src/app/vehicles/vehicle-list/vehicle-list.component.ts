import {Component, OnInit, ViewChild, Input} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Vehicle} from '../vehicle';
import {VehicleService} from '../vehicle.service';

@Component({
  selector: 'app-vehicle-list',
  templateUrl: './vehicle-list.component.html',
  styleUrls: ['./vehicle-list.component.scss']
})
export class VehicleListComponent implements OnInit {

  @Input() showFilter = false;
  @Input() showActions = false;
  @Input() display = 'all';
  dataSource = new MatTableDataSource();


  displayedColumns = ['plate', 'type', 'gas', 'details', 'chofer'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private vehicleService: VehicleService) {}

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
        this.vehicleService.getAvaliableVehicles(now.toJSON(),now.toJSON())
        .subscribe(result => {
          this.dataSource.data = result as Vehicle[];
        });
        break;
      }
      default: {
        this.vehicleService.getVehicles()
        .subscribe(result => {
          this.dataSource.data = result as Vehicle[];
        });
      }
    };      
  }
  
onDelete(vehicle: Vehicle): void {
  if(confirm("¿Estás seguro de que deseas eliminar el vehiculo con patente " + vehicle.plate + "?")) {
    this.vehicleService.delete(vehicle.plate).subscribe(data => this.load());
  }
}

applyFilter(filterValue: string) {
  filterValue = filterValue.trim(); // Remove whitespace
  filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
  this.dataSource.filter = filterValue;
}

  
}
