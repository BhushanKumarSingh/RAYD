import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { UserSignupComponent } from './customer-signup/user-signup.component';
import { AddressComponent } from './address/address.component';
import { AdminComponent } from './admin/admin.component';
import { AdminFirstPageComponent } from './admin/admin-first-page/admin-first-page.component';
import { AllCustomerPageComponent } from './admin/main-content/all-customer-page/all-customer-page.component';
import { ServiceproviderComponent } from './serviceprovider/serviceprovider.component'
import { SpDashboardComponent } from './serviceprovider/main-content/sp-dashboard/sp-dashboard.component';
import { SpServicesComponent } from './serviceprovider/main-content/sp-services/sp-services.component';
import { SpTechniciansComponent } from './serviceprovider/main-content/sp-technicians/sp-technicians.component';
import { IncomingRequestComponent } from './serviceprovider/main-content/incoming-request/incoming-request.component';
import { CustomerFeedbackComponent } from './serviceprovider/main-content/customer-feedback/customer-feedback.component';
import { SpQueryComponent } from './serviceprovider/main-content/sp-query/sp-query.component';

const routes: Routes = [{
    path : 'admin',
    component : AdminComponent,
    children : [{
      path : 'dashboard',
      component : AdminFirstPageComponent
    },
    {
       path : 'customers',
       component : AllCustomerPageComponent
    }
  ]
  },

  {
    path : 'serviceprovider',
    component : ServiceproviderComponent,
    children : [{
      path : 'dashboard',
      component : SpDashboardComponent
    },
    {
       path : 'services',
       component : SpServicesComponent
    },
    {
      path : 'technicians',
      component : SpTechniciansComponent
    },
    {
      path : 'requests',
      component : IncomingRequestComponent
    },
    {
      path : 'feedback',
      component : CustomerFeedbackComponent
    },
    {
      path : 'myquery',
      component : SpQueryComponent
    }
  ]
  },
  
  {path: "loginpage", component: LoginpageComponent},
  {path: "customersignup", component: UserSignupComponent},
  {path: "addresspage", component: AddressComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
