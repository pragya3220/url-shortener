import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {AuthService} from "../../services/auth.service";
import {ShortService} from "../../services/short.service";
import {User} from "../../model/model.user";
import {Url} from "../../model/model.url";
import {Router} from "@angular/router";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class ProfileComponent implements OnInit {
  url: Url=new Url();
  urls: Url[];
  errorMessage:string;
  unauthUrl:string;
  currentUser: User;

  constructor(public authService: AuthService, public shortService: ShortService, public router: Router) {
    this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
  }

  ngOnInit() {
    this.getUrlListByUserId(this.currentUser.id);
  }

  getUrlListByUserId(userId){
    this.shortService.getUrlListByUserId(userId)
    .subscribe( data => {
      this.urls = data.json();
    });
  }

  shorten(){
    if(this.url.longUrl){
      this.url.userId = this.currentUser.id;
      this.shortService.createUrl(this.url).subscribe(data=>{
        this.unauthUrl = data.json().longUrl;
        this.url.longUrl = data.json().shortUrl;
        this.url.shortUrl = data.json().shortUrl;
        this.errorMessage = null;
        this.getUrlListByUserId(this.currentUser.id);
        },err=>{
        this.errorMessage="error :  cannot shorten this link";
        }
      )
      
    }else{
      this.errorMessage = "URL is required";
      this.unauthUrl = null;
      this.url.longUrl = null;
      this.url.shortUrl = null;
    }
    
  }
  
// logout from the app
  logOut() {
    this.authService.logOut()
      .subscribe(
        data => {
          alert("Employee created successfully.");
          this.router.navigate(['/login']);
        },
        error => {

        });
  }
}
