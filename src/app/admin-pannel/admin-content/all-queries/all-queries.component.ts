import { Component, OnInit } from '@angular/core';
import { AppService } from 'src/app/app.service';
import { NgxSpinnerService } from 'ngx-spinner';

@Component({
  selector: 'app-all-queries',
  templateUrl: './all-queries.component.html',
  styleUrls: ['./all-queries.component.css']
})
export class AllQueriesComponent implements OnInit {

  queryObj : any;
  mailMsg : any;
  constructor(private adminService : AppService, private spinnerService: NgxSpinnerService) { }

  ngOnInit() {
    this.spinnerService.show();
    let resp1 = this.adminService.getAllQuery();
    resp1.subscribe((data) => {
      this.queryObj = data;
      console.log(this.queryObj);
      this.spinnerService.hide();
    });

  }

  public sendMail(queryId, adminMailText) {
    this.spinnerService.show();
    console.log(queryId + "-------" + adminMailText);
    let resp2 = this.adminService.sendMail(queryId, adminMailText);
    resp2.subscribe((data1) => {
      this.mailMsg = data1;
      alert(this.mailMsg);
      this.ngOnInit();
      this.spinnerService.hide();
    });
  }

}
