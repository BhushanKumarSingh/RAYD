import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginpageComponent } from './loginpage/loginpage.component';

import { ServiceProvideSignupComponent } from './service-provide-signup/service-provide-signup.component';
import { HeaderComponent } from './header/header.component';
import { UserSignupComponent } from './customer-signup/user-signup.component';
import { AddressComponent } from './address/address.component';
import { FooterComponent } from './footer/footer.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AdminModule } from './admin/admin.module';
import { ServiceproviderModule } from './serviceprovider/serviceprovider.module';
import { HomepageComponent } from './homepage/homepage.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginpageComponent,
    UserSignupComponent,
    ServiceProvideSignupComponent,
    HeaderComponent,
    AddressComponent,
    FooterComponent,
    HomepageComponent,
    
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    AdminModule,
    ServiceproviderModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
