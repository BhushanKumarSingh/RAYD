import { Injectable } from '@angular/core';
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
  this.http.post(this.baseURL + "charge", grandTotal, 
  {headers: headers})
    .subscribe(resp => {
      console.log(resp);
    })
  }
}
