import {Leave} from '../leave';
import {Component, OnInit, Input, ViewChild} from '@angular/core';
import {DriverService} from '../driver.service';
import {MatDialog, MatDialogRef, MAT_DIALOG_DATA} from '@angular/material';
import {MatPaginator, MatTableDataSource, MatSort} from '@angular/material';

@Component({
  selector: 'app-driver-leave',
  templateUrl: './driver-leave.component.html',
  styleUrls: ['./driver-leave.component.css']
})
export class DriverLeaveComponent implements OnInit {

  @Input() rut: string;
  dataSource = new MatTableDataSource();
  displayedColumns = ['dateStart', 'dateEnd', 'actions'];
  @Input() leave = new Leave();
  @ViewChild(MatPaginator) paginator: MatPaginator;
  @ViewChild(MatSort) sort: MatSort;
  
  constructor(private driverService: DriverService) {}

  ngOnInit() {
    this.loadData();
  }

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  }

  loadData() {
    this.driverService.getLeaves(this.rut).subscribe(entries => this.dataSource.data = entries);
  }

  addLeave() {
    this.leave.rut = this.rut;
    this.driverService.addLeave(this.leave).subscribe(res => this.loadData());
    this.leave = new Leave();
  }

  onDelete(leave: Leave) {
    if (confirm("¿Está seguro de que quiere eliminar el registro? Esta acción no se puede deshacer")) {
      this.driverService.deleteLeave(leave).subscribe(res => this.loadData());
    }
  }
}
