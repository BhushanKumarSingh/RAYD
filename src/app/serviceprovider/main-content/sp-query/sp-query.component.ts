import { Component, OnInit, ElementRef } from '@angular/core';
import { ServiceproviderService } from '../../serviceprovider.service';
import { SpQuery } from '../../main-content/sp-query/sp-query';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-sp-query',
  templateUrl: './sp-query.component.html',
  styleUrls: ['./sp-query.component.css']
})
export class SpQueryComponent implements OnInit {

  spId : number =1;
  spObj : any;
  spObjArr : any = [];
  constructor(private spService:ServiceproviderService, private SpinnerService: NgxSpinnerService) { }

  ngOnInit() {
  }

  public saveQuery(queryTitle, query) {
    this.SpinnerService.show();
    let date: Date = new Date();
    let resp1 = this.spService.getSpDetails(this.spId);
    resp1.subscribe((data) => {
      this.spObj = data;
      var str = this.spObj + '';
      this.spObjArr = str.split(",");
      let isSolved : boolean = false;
      let spQueryObj : SpQuery = new SpQuery(this.spId, this.spObjArr[0], this.spObjArr[1], queryTitle, query, date, isSolved);
      this.SpinnerService.hide();
      this.spService.saveQuery(spQueryObj);

    });
  }

}
