import { Component, OnInit } from '@angular/core';
import { ServiceproviderService } from '../../serviceprovider.service';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-customer-feedback',
  templateUrl: './customer-feedback.component.html',
  styleUrls: ['./customer-feedback.component.css']
})
export class CustomerFeedbackComponent implements OnInit {
  s : number = 0;
  spId : number = 11;
  allFeedbackObj : any;
  userId : any = [];
  customerName : any = [];
  productName : any = [];
  description : any = [];
  feedbackText : any = [];

  constructor(private spService:ServiceproviderService,private spinnerService: NgxSpinnerService) { }

  ngOnInit() {
    this.spinnerService.show();
    let resp1 = this.spService.getFeedback(this.spId);
    resp1.subscribe((data) => {
      this.allFeedbackObj = data;
      console.log(this.allFeedbackObj);

      for(var k=0; k < this.allFeedbackObj.length; k++) {
        
        if(this.allFeedbackObj[k].feedback != null) {
          this.userId[k] = this.allFeedbackObj[k].userId;
          this.productName[k] = this.allFeedbackObj[k].productName;
          this.description[k] = this.allFeedbackObj[k].description;
          this.feedbackText[k] = this.allFeedbackObj[k].feedback.feedbackText;
        }
      }
      for(var n = 0; n < this.userId.length; n++) {
        let uId = this.userId[n];
        let resp2 = this.spService.getUserName(uId);
        
        resp2.subscribe((data1) => {
          this.customerName[this.s] = data1;
          this.s = this.s + 1;
        });
      }
      // console.log(this.customerName);
      // console.log(this.userId);
      // console.log(this.productName);
      // console.log(this.description);
      // console.log(this.feedbackText);
    });
    this.spinnerService.hide();
  }
  

}
