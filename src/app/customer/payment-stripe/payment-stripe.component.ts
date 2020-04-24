import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { Payment } from '../../customer/payment-stripe/payment';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-payment-stripe',
  templateUrl: './payment-stripe.component.html',
  styleUrls: ['./payment-stripe.component.css']
})
export class PaymentStripeComponent implements OnInit {

  grandTotal : number = 1;
  private paymentObj : Payment = new Payment();
  constructor(private customerService : AppService) { }


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
    console.log(this.paymentObj.expYear);

   // let form = document.getElementsByTagName("form")[0];
    (<any>window).Stripe.card.createToken({
      number: this.paymentObj.cardNumber,
      exp_month: this.paymentObj.expMonth,
      exp_year: this.paymentObj.expYear,
      cvc: this.paymentObj.cvc
    }, (status: number, response: any) => {
      if (status === 200) {
        let token = response.id;
        alert(token);
        this.customerService.chargeCard(token, this.grandTotal);
      } else {
        alert(response.error.message);
      }
    });
  }

}
