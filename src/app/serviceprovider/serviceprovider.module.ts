import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SpSidebarComponent } from './sp-sidebar/sp-sidebar.component';
import { SpDashboardComponent } from './main-content/sp-dashboard/sp-dashboard.component';
import { IncomingRequestComponent } from './main-content/incoming-request/incoming-request.component';
import { SpServicesComponent } from './main-content/sp-services/sp-services.component';
import { CustomerFeedbackComponent } from './main-content/customer-feedback/customer-feedback.component';
import { SpQueryComponent } from './main-content/sp-query/sp-query.component';
import { RouterModule } from '@angular/router';
import { ServiceproviderComponent } from './serviceprovider.component';
import { HttpClientModule } from '@angular/common/http';
import { TechnicianModule } from './main-content/technician/technician.module';



@NgModule({
  declarations: [
    ServiceproviderComponent,
    SpSidebarComponent,
    SpDashboardComponent,
    IncomingRequestComponent,
    SpServicesComponent,
    CustomerFeedbackComponent,
    SpQueryComponent,
    
  ],
  imports: [
    CommonModule,
    RouterModule,
    HttpClientModule,
    TechnicianModule
  ]
})
export class ServiceproviderModule { }
