import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ShortService} from "../../services/short.service";
import {Url} from "../../model/model.url";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class HomeComponent implements OnInit {
  url: Url=new Url();
  errorMessage:string;
  unauthUrl:string;
  constructor(public shortService: ShortService, public router: Router) {

  }

  ngOnInit() {

  }

  shorten(){
    if(this.url.longUrl){
      this.shortService.createUrl(this.url).subscribe(data=>{
        this.unauthUrl = data.json().longUrl;
        this.url.longUrl = data.json().shortUrl;
        this.url.shortUrl = data.json().shortUrl;
        this.errorMessage = null;
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

}
