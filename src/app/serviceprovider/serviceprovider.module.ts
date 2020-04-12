import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SpSidebarComponent } from './sp-sidebar/sp-sidebar.component';
import { SpDashboardComponent } from './main-content/sp-dashboard/sp-dashboard.component';
import { IncomingRequestComponent } from './main-content/incoming-request/incoming-request.component';
import { SpServicesComponent } from './main-content/sp-services/sp-services.component';
import { CustomerFeedbackComponent } from './main-content/customer-feedback/customer-feedback.component';
import { SpQueryComponent } from './main-content/sp-query/sp-query.component';
import { SpTechniciansComponent } from './main-content/sp-technicians/sp-technicians.component';
import { RouterModule } from '@angular/router';
import { ServiceproviderComponent } from './serviceprovider.component';



@NgModule({
  declarations: [
    ServiceproviderComponent,
    SpSidebarComponent,
    SpDashboardComponent,
    IncomingRequestComponent,
    SpServicesComponent,
    CustomerFeedbackComponent,
    SpQueryComponent,
    SpTechniciansComponent
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class ServiceproviderModule { }
