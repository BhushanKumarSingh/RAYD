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
import { SpTechniciansComponent } from './serviceprovider/main-content/technician/sp-technicians/sp-technicians.component';
import { IncomingRequestComponent } from './serviceprovider/main-content/incoming-request/incoming-request.component';
import { CustomerFeedbackComponent } from './serviceprovider/main-content/customer-feedback/customer-feedback.component';
import { SpQueryComponent } from './serviceprovider/main-content/sp-query/sp-query.component';
import { HomepageComponent } from './homepage/homepage.component';
import { SpAddTechnicianComponent } from './serviceprovider/main-content/technician/sp-add-technician/sp-add-technician.component';
import { TechnicianComponent } from './serviceprovider/main-content/technician/technician.component';

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
        path : 'technician',
        component : TechnicianComponent,
        children : [{
          path : '',
          component : SpTechniciansComponent
        },
        {
          path : 'addtechnician',
          component : SpAddTechnicianComponent
        }]
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
  
  {path : "loginpage", component: LoginpageComponent},
  {path : "customersignup", component: UserSignupComponent},
  {path : "addresspage", component: AddressComponent},
  {path : "", component : HomepageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
