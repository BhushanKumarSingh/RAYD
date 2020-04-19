import { Component, OnInit } from '@angular/core';
import { ServiceproviderService } from 'src/app/serviceprovider/serviceprovider.service';

@Component({
  selector: 'app-sp-technicians',
  templateUrl: './sp-technicians.component.html',
  styleUrls: ['./sp-technicians.component.css']
})
export class SpTechniciansComponent implements OnInit {
  id:number = 1;
  spObj:any;
  serviceProviderTechie:any;
  constructor(private spService:ServiceproviderService) { }

  ngOnInit() {
    let response = this.spService.getTechnicianData(this.id);
      response.subscribe((data)=>{
        this.spObj = data;
        console.log(this.spObj);
      });
  }
}
