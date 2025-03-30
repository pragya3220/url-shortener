import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./components/login/login.component";
import {RegisterComponent} from "./components/register/register.component";
import {ProfileComponent} from "./components/profile/profile.component";
import {HomeComponent} from "./components/home/home.component";
import {ForwardComponent} from "./components/forward/forward.component";
import {UrlPermission} from "./urlPermission/url.permission";

const appRoutes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'profile', component: ProfileComponent, canActivate: [UrlPermission] },
  { path: ':key', component: ForwardComponent },
  //{ path: '**', redirectTo: '/home' }
];

export const routing = RouterModule.forRoot(appRoutes);
