import { Injectable, NgZone } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient,HttpErrorResponse, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AppService {

  constructor(private http:HttpClient, private router:Router) { }
  private baseURL= "http://localhost:8080/";

  public getInvoice(orderId) {
    return this.http.post(this.baseURL + "getInvoice", orderId);
  }

  public chargeCard(token , grandTotal) {
    const headers = new HttpHeaders({'token': token});
    //let options = { headers: headers };
    return this.http.post(this.baseURL + "charge", grandTotal, {headers: headers});
  }

  public sendFeedback(srId: number, starValue: any, feedbackText: any) {
    const headers = new HttpHeaders({'starValue': starValue, 'feedbackText' : feedbackText});
    return this.http.post(this.baseURL + "savefeedback", srId, {headers : headers, responseType:'text'});
  }

  savePaymentStatus(paymentObj1) {
    //const headers = new HttpHeaders({'transactionId' : transactionId,  'status' : status});
    this.http.post(this.baseURL + "savePaymentData", paymentObj1) 
    .subscribe(resp => {
      console.log(resp);
    });
  }

  public getAllQuery() {
    return this.http.get(this.baseURL + "getallquery");
  }

  public sendMail(queryId: number, adminMailText: any) {
    const headers = new HttpHeaders({'adminMailText' : adminMailText});
    return this.http.post(this.baseURL + "sendmail", queryId, {headers : headers, responseType:'text'});
  }

}
