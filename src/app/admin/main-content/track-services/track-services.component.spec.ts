import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackServicesComponent } from './track-services.component';

describe('TrackServicesComponent', () => {
  let component: TrackServicesComponent;
  let fixture: ComponentFixture<TrackServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
