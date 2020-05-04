import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from  '@angular/common/http';
import { Router } from '@angular/router';
import { SpQuery } from './main-content/sp-query/sp-query';

@Injectable({
  providedIn: 'root'
})
export class ServiceproviderService {
  
  private baseURL= "http://localhost:8080/";
  constructor(private http:HttpClient, private router:Router) { }

  public displayServiceProviderProfile(spId) {
    return this.http.post(this.baseURL + "displayProfile", spId);
  }

  public saveTechieData(technicianObj) {
    return  this.http.post(this.baseURL + "saveTechnician", technicianObj);
  }

  public getTechnicianData(id) {
    return this.http.post(this.baseURL + "displayTechnician",  id);
  }

  public addProduct (spId, productName) {
    const headers = new HttpHeaders({'productName': productName});
    return this.http.post(this.baseURL + "addProductName", spId, {headers: headers, responseType:'text'});
  }

  public getFeedback(spId: number) {
    return this.http.post(this.baseURL + "getallfeedback", spId);
  }

  public getUserName(userId: number) {
    return this.http.post(this.baseURL + "getUserName", userId, {responseType:'text'});
  }

  public getSpDetails(spId: number) {
    console.log("hi");
    return this.http.post(this.baseURL + "getspdetails", spId);
  }

  public saveQuery(spQueryObj: SpQuery) {
    console.log("hello");
    this.http.post(this.baseURL + "savequery", spQueryObj, {responseType:'text'})
    .subscribe((msg) => {
      alert(msg);
    });
  }
}
