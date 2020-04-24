import { Component, OnInit } from '@angular/core';
import { FormGroup,FormControl } from "@angular/forms";
import { RaydService } from "../rayd.service";

@Component({
  selector: 'app-user-signup',
  templateUrl: './user-signup.component.html',
  styleUrls: ['./user-signup.component.css']
})
export class UserSignupComponent implements OnInit {
  signUpForm = new FormGroup({
    firstName: new FormControl(''),
    lastName: new FormControl(''),
    email: new FormControl(''),
    password: new FormControl(''),
    phoneNumber: new FormControl(''),
    rePassword: new FormControl(''),
    role: new FormControl('')
  })

  constructor(private raydService:RaydService) {
  
   }

  ngOnInit() {
  }

 
  getBgImage()
  {
    return "url('../../assets/img/background.svg')";
  }
  
  set(){
    this.raydService.signUpDetails.setFirstName=this.signUpForm.get('firstName').value;
    this.raydService.signUpDetails.setLastName=this.signUpForm.get('lastName').value;
    this.raydService.signUpDetails.setPassword=this.signUpForm.get('password').value;
    this.raydService.signUpDetails.setRoles=this.signUpForm.get('role').value;
    this.raydService.signUpDetails.setEmailId=this.signUpForm.get('email').value;
    this.raydService.signUpDetails.setPhoneNumber=this.signUpForm.get('phoneNumber').value;
    this.raydService.flagForCustomer=true;
   
  }
}
