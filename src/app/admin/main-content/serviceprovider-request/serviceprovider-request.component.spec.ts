import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ServiceproviderRequestComponent } from './serviceprovider-request.component';

describe('ServiceproviderRequestComponent', () => {
  let component: ServiceproviderRequestComponent;
  let fixture: ComponentFixture<ServiceproviderRequestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ServiceproviderRequestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ServiceproviderRequestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
