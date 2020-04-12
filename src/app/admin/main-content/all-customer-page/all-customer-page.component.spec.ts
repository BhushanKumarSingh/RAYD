import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AllCustomerPageComponent } from './all-customer-page.component';

describe('AllCustomerPageComponent', () => {
  let component: AllCustomerPageComponent;
  let fixture: ComponentFixture<AllCustomerPageComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AllCustomerPageComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AllCustomerPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
