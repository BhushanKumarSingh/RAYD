import { Component, OnInit } from '@angular/core';
import { RaydService } from 'src/app/rayd.service';
import { FormGroup, FormControl, FormsModule } from '@angular/forms';

@Component({
  selector: 'app-service-provider-service',
  templateUrl: './service-provider-service.component.html',
  styleUrls: ['./service-provider-service.component.css']
})
export class ServiceProviderServiceComponent implements OnInit {
  statusForm=new FormGroup({
    status:new FormControl(''),
    patsName:new FormControl(''),
    price:new FormControl(''),
    quantity:new FormControl(''),
    reviewMessage:new FormControl(''),
    serviceCharge:new FormControl('')
  })

  constructor(private raydService:RaydService) { }

servicesRequest;
 async ngOnInit() {
   await this.raydService.getAcctedService();
   this.servicesRequest=this.raydService.servicesProblem
  }
  service;
  visited=false;
  completed=false;
  view=false
  async details(event){
     this.service=event;
     console.log(event[0])
     this.view=true;
     
  }

  visit(){
    
    if(this.statusForm.get('status').value=="visit"){
      this.completed=false;
    this.visited=true;
    }
    else{
      this.visited=false;
      this.completed=true;
    }
  }
  complete(){
    
    console.log("complete")
  }
    
  async saveStatus(){
    if(this.visited){
      this.raydService.visitingDetails.setServiceRequestId=this.service[0];
      this.raydService.visitingDetails.setVisitingMessage=this.statusForm.get('reviewMessage').value;
      await this.raydService.saveStatus();
    }
    else if(this.completed){
      this.raydService.orderDetails.setPartsName=this.statusForm.get('patsName').value;
      this.raydService.orderDetails.setPrice=this.statusForm.get('price').value;
      this.raydService.orderDetails.setQuantity=this.statusForm.get('quantity').value;
      this.raydService.orderDetails.setServiceRequestId=this.service[0];
      this.raydService.orderDetails.setServiceCharge=this.statusForm.get('serviceCharge').value;
     await this.raydService.saveOrderDetails();
    }
    
  }
  accepted(status){
    if(status==1)
    return true;
  
  }
  completed1(status){
    if(status==2)
    return true;
  }
  visited1(status){
    if(status==3)
    return true;
  }
  async upadteStatus(){
    await this.raydService.getAcctedService();
   this.servicesRequest=this.raydService.servicesProblem;
  }
  

}
