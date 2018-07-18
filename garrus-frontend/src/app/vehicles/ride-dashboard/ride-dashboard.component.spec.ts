import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RideDashboardComponent } from './ride-dashboard.component';

describe('RideDashboardComponent', () => {
  let component: RideDashboardComponent;
  let fixture: ComponentFixture<RideDashboardComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RideDashboardComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RideDashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
