import { Injectable } from '@angular/core';
import { HttpClient } from  '@angular/common/http';
import { Router } from '@angular/router';

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
    console.log(technicianObj);
    return  this.http.post(this.baseURL + "saveTechnician", technicianObj);
  }

  public getTechnicianData(id) {
    console.log("get technician called..");
    return this.http.post(this.baseURL + "displayTechnician",  id);
  }
}
