import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AutosizeModule } from 'ngx-autosize';
import { ChartsModule } from 'ng4-charts/ng4-charts';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { FormsModule } from '@angular/forms';
import { AuthService } from "./services/auth.service";
import {HttpModule} from "@angular/http";
import {AccountService} from "./services/account.service";
import { ProfileComponent } from './components/profile/profile.component';
import { HomeComponent } from './components/home/home.component';
import { ForwardComponent } from './components/forward/forward.component';
import {routing} from "./app.routing";
import {UrlPermission} from "./urlPermission/url.permission";
import { ShortService } from "./services/short.service"; 
@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegisterComponent,
    ProfileComponent,
    HomeComponent,
    ForwardComponent
  ],
  imports: [
    BrowserModule,HttpModule,FormsModule,routing,AutosizeModule,ChartsModule
  ],
  providers: [AuthService, AccountService, ShortService, UrlPermission],
  bootstrap: [AppComponent]
})
export class AppModule { }
