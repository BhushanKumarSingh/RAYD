import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerInvoicePdfComponent } from './customer-invoice-pdf.component';

describe('CustomerInvoicePdfComponent', () => {
  let component: CustomerInvoicePdfComponent;
  let fixture: ComponentFixture<CustomerInvoicePdfComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ CustomerInvoicePdfComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerInvoicePdfComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
