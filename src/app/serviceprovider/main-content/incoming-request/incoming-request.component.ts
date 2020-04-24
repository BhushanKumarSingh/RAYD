import { Component, OnInit } from '@angular/core';
import { RaydService } from 'src/app/rayd.service';
import { AddProblem } from 'src/app/add-problem';

@Component({
  selector: 'app-incoming-request',
  templateUrl: './incoming-request.component.html',
  styleUrls: ['./incoming-request.component.css']
})
export class IncomingRequestComponent implements OnInit {

  constructor(private raydService:RaydService) { }

 async ngOnInit() {
     await this.raydService.getOpenRequest();
     this.openRequest=this.raydService.openRequest;
  }
  openRequest;
  async getOpenRequestData(){
    await this.raydService.getOpenRequest();
    this.openRequest=this.raydService.openRequest;
    console.log(this.openRequest);
    
  }
  requestData=new AddProblem();
  async accept(event){
    this.requestData.setServiceRequestId=event[0];
    this.requestData.setCompanyName=event[1];
    this.requestData.setProductName=event[2]
    this.requestData.setDescription=event[3];
    this.requestData.setAddressId=event[4];
    this.requestData.setModelNumber=event[5];
    this.requestData.setProductType=event[6];
    this.requestData.setCompleteAddress=event[8]
    this.requestData.setCurrentLocation=event[9];
    this.requestData.setPinCode=event[10];
    this.requestData.setUserId=event[11];
    this.requestData.setServiceProviderId=29;


     await this.raydService.acceptRequest(this.requestData);
     await this.raydService.getOpenRequest();
     this.openRequest=this.raydService.openRequest;
     this.getOpenRequestData();
     console.log(this.openRequest);
    
  }


}
