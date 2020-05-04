import { Component, OnInit } from '@angular/core';
import { AppService }  from '../../app.service';
import * as jsPDF from 'jspdf'
import * as html2canvas from 'html2canvas';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-customer-invoice',
  templateUrl: './customer-invoice.component.html',
  styleUrls: ['./customer-invoice.component.css']
})
export class CustomerInvoiceComponent implements OnInit {
  orderId : number = 1;
  invoiceObj : any;
  partsObj : any;
  customerParts : any;
  totalPrice : number;
  subTotal : number = 0;
  taxAmount : number;
  grandTotal : number;

  constructor(private customerService : AppService, private SpinnerService: NgxSpinnerService) { }

  ngOnInit() {
    let resp1 = this.customerService.getInvoice(this.orderId);
    resp1.subscribe((data)=>{
      this.invoiceObj = data;
      this.customerParts = this.invoiceObj.parts;
      for(var index in this.customerParts) {
          this.totalPrice = this.customerParts[index].price * this.customerParts[index].quantity;
          this.subTotal = this.subTotal + this.totalPrice;     
      }
      this.taxAmount = Math.round(this.subTotal / 12);
      this.grandTotal = this.subTotal + Math.round(this.taxAmount);
      console.log(this.grandTotal);
    });
  }

  public generatePdf() {
    this.SpinnerService.show();
    var data = document.getElementById('invoiceForm');
    html2canvas(data).then((canvas) =>{
      var imgWidth = 208;
      var pageHeight =296;
      var imgHeight = canvas.height * imgWidth / canvas.width;
      var heightLeft = imgHeight;

      const contentDataURL = canvas.toDataURL('image/png');
      let pdf = new jsPDF("p", "mm", "a4");
      var position = 0;
      pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight);
      this.SpinnerService.hide();
      pdf.save('File.pdf');
    });
  }


}
