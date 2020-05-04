import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginpageComponent } from './loginpage/loginpage.component';
import { UserSignupComponent } from './customer-signup/user-signup.component';
import { AddressComponent } from './address/address.component';
import { ServiceproviderComponent } from './serviceprovider/serviceprovider.component'
import { SpDashboardComponent } from './serviceprovider/main-content/sp-dashboard/sp-dashboard.component';
import { SpTechniciansComponent } from './serviceprovider/main-content/technician/sp-technicians/sp-technicians.component';
import { IncomingRequestComponent } from './serviceprovider/main-content/incoming-request/incoming-request.component';
import { CustomerFeedbackComponent } from './serviceprovider/main-content/customer-feedback/customer-feedback.component';
import { SpQueryComponent } from './serviceprovider/main-content/sp-query/sp-query.component';
import { HomepageComponent } from './homepage/homepage.component';
import { SpAddTechnicianComponent } from './serviceprovider/main-content/technician/sp-add-technician/sp-add-technician.component';
import { TechnicianComponent } from './serviceprovider/main-content/technician/technician.component';
import { ChangePasswordComponent } from './change-password/change-password.component';
import { CustomerInvoiceComponent } from './customer/customer-invoice/customer-invoice.component';
import { PaymentStripeComponent } from './customer/payment-stripe/payment-stripe.component';
import { AdminPannelComponent } from './admin-pannel/admin-pannel.component';
import { ServiceProviderRequestComponent } from './admin-pannel/admin-content/service-provider-request/service-provider-request.component';
import { ServiceProviderServiceComponent } from './serviceprovider/main-content/service-provider-service/service-provider-service.component';
import { ServiceProvideSignupComponent } from './service-provide-signup/service-provide-signup.component';
import { UserDashboardComponent } from './user-dashboard/user-dashboard.component';
import { AddProblemComponent } from './add-problem/add-problem.component';
import { FeedbackComponent } from './customer/feedback/feedback.component';
import { AllQueriesComponent } from './admin-pannel/admin-content/all-queries/all-queries.component';


const routes: Routes = [
  {path: "customerLogin", component: LoginpageComponent},
  {path: "customersignup", component: UserSignupComponent},
  {path: "addresspage", component: AddressComponent},
  {path: "serviceProviderSignUp",component:ServiceProvideSignupComponent},
  {path:"userDashboard",component:UserDashboardComponent},
  {path:"addProblem",component:AddProblemComponent},
  {path:"adminLogin",component:LoginpageComponent},
  {path:"ServiceProviderLogin",component:LoginpageComponent},
  {path:"home",component:HomepageComponent},
  {path : "", component : HomepageComponent},
  {path : "changepassword", component : ChangePasswordComponent},
  {path : "repairinvoice", component : CustomerInvoiceComponent},
  {path : "paystripe",  component : PaymentStripeComponent},
  {path : "feedback", component : FeedbackComponent},
  
  {path:"admin",component:AdminPannelComponent,
    children:[
      {path:"serviceProviderRequest",component:ServiceProviderRequestComponent},
      {path : "allqueries", component : AllQueriesComponent}
    ]
  },
  {path : 'serviceprovider', component : ServiceproviderComponent,
    children : [
      {path : 'dashboard', component : SpDashboardComponent},
      {path : 'services', component : ServiceProviderServiceComponent},
      {path : 'technician', component : TechnicianComponent,
          children : [
            {path : '', component : SpTechniciansComponent},
            {path : 'addtechnician', component : SpAddTechnicianComponent}
          ]
      },
      {path : 'requests', component : IncomingRequestComponent},
      {path : 'feedback', component : CustomerFeedbackComponent},
      {path : 'myquery', component : SpQueryComponent}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
