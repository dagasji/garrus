import {Entry} from '../entry';
import {Component, OnInit, Input} from '@angular/core';
import {VehicleService} from '../vehicle.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {MatPaginator, MatTableDataSource} from '@angular/material';

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
  constructor(private vehicleService: VehicleService) {}

  ngOnInit() {
    this.loadData();
  }

  loadData() {
    this.vehicleService.loadEntry(this.plate).subscribe(entries => this.dataSource.data = entries);
  }

  addEntry() {
    this.entry.plate = this.plate;
    this.vehicleService.pushEntry(this.entry).subscribe(res => this.loadData());
  }

  onDelete(entry: Entry) {
    if (confirm("¿Está seguro de que quiere eliminar el registro? Esta acción no se puede deshacer")){
      this.vehicleService.deleteEntry(entry).subscribe(res => this.loadData());
    }
  }
}
