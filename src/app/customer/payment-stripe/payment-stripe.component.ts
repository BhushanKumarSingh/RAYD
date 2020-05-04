import { Component, OnInit, NgZone } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Payment } from '../../customer/payment-stripe/payment';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { PaymentStatus } from '../payment-stripe/paymentstatus';
import { Router } from '@angular/router';
import { FeedbackComponent } from '../feedback/feedback.component';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-payment-stripe',
  templateUrl: './payment-stripe.component.html',
  styleUrls: ['./payment-stripe.component.css']
})

export class PaymentStripeComponent implements OnInit {
  srId : number = 101;
  grandTotal : number = 1;
  paymentObject : any;
   
  private paymentObj : Payment = new Payment();
  constructor(private customerService : AppService, private router:Router,  private zone:NgZone, private SpinnerService: NgxSpinnerService) { }


  paymentForm = new FormGroup({
    cardName : new FormControl('', Validators.required),
    cardNumber : new FormControl('', Validators.required),
    expMonth : new FormControl('', Validators.required),
    expYear : new FormControl('', Validators.required),
    cvc : new FormControl('', Validators.required),
  });
  ngOnInit() {
  }

  public chargeCreditCard() {
    this.SpinnerService.show();
    console.log(this.paymentObj.expYear);
    (<any>window).Stripe.card.createToken({
      number: this.paymentObj.cardNumber,
      exp_month: this.paymentObj.expMonth,
      exp_year: this.paymentObj.expYear,
      cvc: this.paymentObj.cvc
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        // alert(token);
       let resp1 = this.customerService.chargeCard(token, this.grandTotal);
       resp1.subscribe(resp => {
          this.paymentObject = resp;
          let transactionId = this.paymentObject.id;
          let grandTotal = this.paymentObject.amount/100;
          let status = this.paymentObject.paid;

          let paymentObj1: PaymentStatus = new PaymentStatus(this.srId, transactionId, grandTotal, status);
          this.customerService.savePaymentStatus(paymentObj1);
          this.SpinnerService.hide();
          alert("Your transaction is successful.");
          this.zone.run(() => this.router.navigate(['repairinvoice']));
       });
      } else {
        alert(response.error.message);
      }
    });
  }
}
