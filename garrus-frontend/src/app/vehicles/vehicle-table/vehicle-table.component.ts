import {Component, ViewChild, OnInit} from '@angular/core';
import {MatPaginator, MatTableDataSource} from '@angular/material';
import {Vehicle} from '../vehicle';
import {VehicleService} from '../vehicle.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';

@Component({
  selector: 'app-vehicle-table',
  templateUrl: './vehicle-table.component.html',
  styleUrls: ['./vehicle-table.component.css']
})
export class VehicleTableComponent implements OnInit {

  dataSource = new MatTableDataSource();
  displayedColumns = ['plate', 'type', 'gas', 'details', 'chofer', 'actions'];

  @ViewChild(MatPaginator) paginator: MatPaginator;

  constructor(private vehicleService: VehicleService, public dialog: MatDialog) {}

  ngOnInit() {
    this.load();
  }

  load() {
     this.vehicleService.getVehicles()
      .subscribe(result => {
        this.dataSource.data = result as Vehicle[];
      });
  }
  
  onDelete(vehicle: Vehicle): void {
    if (confirm("¿Estás seguro de que deseas eliminar el vehiculo con patente " + vehicle.plate + "?")) {
      this.vehicleService.delete(vehicle.plate).subscribe(data => this.load());
    }
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }


}


