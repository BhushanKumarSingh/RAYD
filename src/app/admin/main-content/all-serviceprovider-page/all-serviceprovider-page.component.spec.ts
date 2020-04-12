import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllServiceproviderPageComponent } from './all-serviceprovider-page.component';

describe('AllServiceproviderPageComponent', () => {
  let component: AllServiceproviderPageComponent;
  let fixture: ComponentFixture<AllServiceproviderPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllServiceproviderPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllServiceproviderPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
