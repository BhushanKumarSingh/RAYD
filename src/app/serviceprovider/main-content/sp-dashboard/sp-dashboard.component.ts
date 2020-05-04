import { Component, OnInit } from '@angular/core';
import { ServiceproviderService } from '../../serviceprovider.service';
import { Router, RouterModule } from '@angular/router';
import { ThrowStmt } from '@angular/compiler';
@Component({
  selector: 'app-sp-dashboard',
  templateUrl: './sp-dashboard.component.html',
  styleUrls: ['./sp-dashboard.component.css']
})
export class SpDashboardComponent implements OnInit {
  spId:number = 1;
  serviceProviderProfile : any;
  serviceProviderAddress : any;
  serviceProviderService : any;
  serviceProvideServiceCatagory : any;

  response1:any;

  constructor(private spService:ServiceproviderService) { }

  ngOnInit() {
    let resp1 = this.spService.displayServiceProviderProfile(this.spId);
    resp1.subscribe((data)=>
    {
      this.serviceProviderProfile = data;
      // this.serviceProviderAddress = Object.values(this.serviceProviderProfile.address);
       console.log(this.serviceProviderProfile);
      // console.log(Object.values(this.serviceProviderProfile));
      // console.log(JSON.stringify( this.serviceProviderProfile.address));
      // console.log(JSON.stringify( this.serviceProviderProfile.category));
      
    });

    // let resp2 = this.spService.displayServiceProviderAddress(this.spId);
    // resp1.subscribe((data)=>
    // {
    //   this.serviceProviderAddress = data;
    //   console.log("serviceProviderAddress :" + this.serviceProviderAddress.completeAddress);
    // });
  }
  public addProductName(productName)  {
    let resp2 = this.spService.addProduct(this.spId, productName);
    resp2.subscribe((data) => {
      this.response1 = data;
      alert(this.response1);
      window.location.reload();  
    },
    error => {
      alert(error.error.message);  
    }
    );
  }

}

