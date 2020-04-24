import { Component, OnInit } from '@angular/core';
import { AppComponent } from "../app.component";
import { FormGroup, FormControl } from '@angular/forms';
import { RaydService } from '../rayd.service';

@Component({
  selector: 'app-user-dashboard',
  templateUrl: './user-dashboard.component.html',
  styleUrls: ['./user-dashboard.component.css']
})
export class UserDashboardComponent implements OnInit {
  addProblemForm=new FormGroup({
    productName:new FormControl(''),
    productType:new FormControl(''),
    modelNumber:new FormControl(''),
    description:new FormControl(''),
    companyName:new FormControl('')

  })
  addressForm = new FormGroup({
    locality:new FormControl(''),
    city:new FormControl(''),
    address:new FormControl(''),
    landmark:new FormControl(''),
    state:new FormControl(''),
    pinCode:new FormControl(''),
    addressType:new FormControl('')

  })

  constructor(private raydService:RaydService ) { }
  addressData;
  notification;
  userName;
  emailId;
  portfolioData;
  ngOnInit() {
    this.notification=1;
    this.raydService.getRequest();
  }
  fetchAddress(){
    this.raydService.getAddress();
  }
  addProblemData(){
    this.raydService.addProblem.setProductName=this.addProblemForm.get('productName').value;
    this.raydService.addProblem.setProductType=this.addProblemForm.get('productType').value;
    this.raydService.addProblem.setModelNumber=this.addProblemForm.get('modelNumber').value;
    this.raydService.addProblem.setDescription=this.addProblemForm.get('description').value;
    this.raydService.addProblem.setCompanyName=this.addProblemForm.get('companyName').value;
    this.raydService.addProblem.setUserId=this.raydService.userData.userId;
}
address(){
  this.addressData=this.raydService.addressResult;
}
addressValue(event:any){
  console.log(event.addressId);
  this.raydService.addProblem.setCurrentLocation=event.currentLocation;
  this.raydService.addProblem.setCompleteAddress=event.completeAddress
  this.raydService.addProblem.setPinCode=event.pinCode;
  this.raydService.addProblem.addressId=event.addressId;
  this.raydService.addProblemRequset();
  this.raydService.getRequest();
}
addNewAddress(){
  var address=this.addressForm.get('landmark').value+", "+this.addressForm.get('city').value+", "+this.addressForm.get('state').value;
  this.raydService.addProblem.setCompleteAddress=address;
  this.raydService.addProblem.setCurrentLocation=this.addressForm.get('locality').value;
  this.raydService.addProblem.setPinCode=this.addressForm.get('pinCode').value;
  this.raydService.addProblem.addressId=0;
  this.raydService.addProblemRequset();
  this.raydService.getRequest();
}
getUser(){
  this.userName=this.raydService.userData.firstName+" "+this.raydService.userData.lastName;
  this.emailId=this.raydService.userData.emailId;
}
portfolioDetails(){
  this.portfolioData=this.raydService.problemRequested;
  console.log(this.portfolioData);
}
open(status){
  if(status=='OPEN')
  return true;
  else
  return false;
}
accepted(status){
 
  if(status=='ACCEPTED'){
  return true;
}

}
completed(status){
  if(status=='COMPLETED')
  return true;
}
visited(status){
  if(status=='VISITED')
  return true;
}
checkPortfolio(){
//   if(this.portfolioData.length>0)
//   return false;
//   else
//   return true;
 }
 visitingMessage;
 async notifiaction(){
   await this.raydService.getVistingDetails();
   this.visitingMessage=this.raydService.vistingMessage;

 }




}
