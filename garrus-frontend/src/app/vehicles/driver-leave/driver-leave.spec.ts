import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DriverLeaveComponent } from './driver-leave.component';

describe('VehicleHistoryComponent', () => {
  let component: DriverLeaveComponent;
  let fixture: ComponentFixture<DriverLeaveComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DriverLeaveComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DriverLeaveComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
