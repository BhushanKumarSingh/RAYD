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

  constructor(private spService:ServiceproviderService) { }

  ngOnInit() {
    let resp1 = this.spService.displayServiceProviderProfile(this.spId);
    resp1.subscribe((data)=>
    {
      this.serviceProviderProfile = data;
      // this.serviceProviderAddress = Object.values(this.serviceProviderProfile.address);
       console.log(this.serviceProviderAddress);
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

}

