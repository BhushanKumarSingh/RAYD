import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SpServicesComponent } from './sp-services.component';

describe('SpServicesComponent', () => {
  let component: SpServicesComponent;
  let fixture: ComponentFixture<SpServicesComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SpServicesComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SpServicesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
