import {Entry} from '../entry';
import {Component, OnInit, Input, ViewChild} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {MatPaginator, MatTableDataSource, MatSort} from '@angular/material';

@Component({
  selector: 'app-vehicle-history',
  templateUrl: './vehicle-history.component.html',
  styleUrls: ['./vehicle-history.component.css']
})
export class VehicleHistoryComponent implements OnInit {

  @Input() plate: string;
  dataSource = new MatTableDataSource();
  displayedColumns = ['info', 'date', 'actions'];
  @Input() entry = new Entry();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  constructor(private vehicleService: VehicleService) {}

  ngOnInit() {
    this.loadData();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  loadData() {
    this.vehicleService.loadEntry(this.plate).subscribe(entries => this.dataSource.data = entries);
  }

  addEntry() {
    this.entry.plate = this.plate;
    this.vehicleService.pushEntry(this.entry).subscribe(res => this.loadData());
    this.entry = new Entry();
  }

  onDelete(entry: Entry) {
    if (confirm("¿Está seguro de que quiere eliminar el registro? Esta acción no se puede deshacer")) {
      this.vehicleService.deleteEntry(entry).subscribe(res => this.loadData());
    }
  }
}
