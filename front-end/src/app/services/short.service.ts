import { Injectable } from '@angular/core';
import {Url} from "../model/model.url";
import {Http} from "@angular/http";
import {AppComponent} from "../app.component";

@Injectable()
export class ShortService {
  constructor(public http: Http) { }

  createUrl(url:Url){
    return this.http.post(AppComponent.API_URL+'/short/add-url',url);
  }

  getUrlByShortUrl(shortUrl:String){
    return this.http.get(AppComponent.API_URL+'/short/get-url-by-short-url/' + shortUrl);
  }

  getUrlListByUserId(userId) {
    return this.http.get(AppComponent.API_URL+"/short/get-urls-by-user-id/" + userId);
  }

}
