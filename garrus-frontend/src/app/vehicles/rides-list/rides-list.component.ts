import {Component, OnInit, Input} from '@angular/core';
import {Ride} from '../ride';
import {RideService} from '../ride.service';
import {MatTableDataSource} from '@angular/material';

@Component({
  selector: 'app-rides-list',
  templateUrl: './rides-list.component.html',
  styleUrls: ['./rides-list.component.scss']
})
export class RidesListComponent implements OnInit {

  //active, next, all
  @Input() display = 'all';
  @Input() columns = 'vehicle,chofer,start,end,details,actions';
  displayedColumns = ['vehicle', 'chofer', 'start', 'end', 'details', 'actions'];

  dataSource = new MatTableDataSource();

  constructor(private rideService: RideService) {}

  ngOnInit() {
    this.load();
    this.displayedColumns = this.columns.split(',');
  }

  load() {
      switch (this.display) {
        case 'active': {
           this.rideService.getActive().subscribe(res => this.dataSource.data = res as Ride[]);
          break;
        }
        case 'next': {
           this.rideService.getNext().subscribe(res => this.dataSource.data = res as Ride[]);
          break;
        }
        case 'past': {
           this.rideService.getPast().subscribe(res => this.dataSource.data = res as Ride[]);
          break;
        }
        default: {
           this.rideService.getAll().subscribe(res => this.dataSource.data = res as Ride[]);
        }
      }
  }

  onDelete(ride: Ride){
    if(confirm("¿Estás seguro de que deseas eliminar el viaje?")) {
      this.rideService.delete(ride.id).subscribe(data => this.load());
    }
  }

  applyFilter(filterValue: string) {
    filterValue = filterValue.trim(); // Remove whitespace
    filterValue = filterValue.toLowerCase(); // MatTableDataSource defaults to lowercase matches
    this.dataSource.filter = filterValue;
  }
}