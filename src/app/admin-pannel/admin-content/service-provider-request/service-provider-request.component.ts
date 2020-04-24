import { Component, OnInit } from '@angular/core';
import { RaydService } from 'src/app/rayd.service';
import { ServiceProvider } from 'src/app/service-provider';

@Component({
  selector: 'app-service-provider-request',
  templateUrl: './service-provider-request.component.html',
  styleUrls: ['./service-provider-request.component.css']
})
export class ServiceProviderRequestComponent implements OnInit {

  constructor(private raydService:RaydService) {
    
  }
  serviceRequest;
  async ngOnInit() {
   await this.raydService.verifyServiceRequest();
    this.serviceRequest=this.raydService.verifyServiceRequestDetails;
    console.log(this.serviceRequest)
    
  }
i;
view=false;
  getDetails(event){
    console.log(event);
    this.i=event;
    this.view=true

  }
  serviceProvider=new ServiceProvider();
  async sendPassword(event){
    this.serviceProvider.setServiceProviderId=event.serviceProviderId;
    this.serviceProvider.setEmailId=event.emailId;
    await this.raydService.sendLoginPassword(this.serviceProvider);
  }
}
