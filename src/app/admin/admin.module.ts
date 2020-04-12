import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { CommonModule } from '@angular/common';

import { AdminSidebarComponent } from './admin-sidebar/admin-sidebar.component';
import { AdminComponent } from './admin.component';
import { AdminFirstPageComponent } from './admin-first-page/admin-first-page.component';
import { AllCustomerPageComponent } from './main-content/all-customer-page/all-customer-page.component';
import { AllServiceproviderPageComponent } from './main-content/all-serviceprovider-page/all-serviceprovider-page.component';
import { AdminServiceComponent } from './main-content/admin-service/admin-service.component';
import { AllFeedbackComponent } from './main-content/all-feedback/all-feedback.component';
import { TrackServicesComponent } from './main-content/track-services/track-services.component';
import { AllQueryComponent } from './main-content/all-query/all-query.component';




@NgModule({
  declarations: [
    AdminSidebarComponent,
    AdminComponent,
    AdminFirstPageComponent,
    AllCustomerPageComponent,
    AllServiceproviderPageComponent,
    AdminServiceComponent,
    AllFeedbackComponent,
    TrackServicesComponent,
    AllQueryComponent,
    
  ],
  imports: [
    CommonModule,
    RouterModule
  ]
})
export class AdminModule { }
