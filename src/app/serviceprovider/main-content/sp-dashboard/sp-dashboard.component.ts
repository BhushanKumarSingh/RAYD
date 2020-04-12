import { Component, OnInit } from '@angular/core';
import { ServiceproviderService } from '../../serviceprovider.service';
import { Router, RouterModule } from '@angular/router';
@Component({
  selector: 'app-sp-dashboard',
  templateUrl: './sp-dashboard.component.html',
  styleUrls: ['./sp-dashboard.component.css']
})
export class SpDashboardComponent implements OnInit {

  serviceProviderProfile : any;
  constructor(private spService : ServiceproviderService, private router:Router, private route: RouterModule) { }

  ngOnInit() {
    this.spService.displayServiceProviderProfile(1).subscribe(
      (response)=>{this.serviceProviderProfile = response;
      }
      );
  }

}
