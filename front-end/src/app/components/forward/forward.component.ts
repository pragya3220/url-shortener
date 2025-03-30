import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import {ShortService} from "../../services/short.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-forward',
  templateUrl: './forward.component.html',
})
export class ForwardComponent implements OnInit {
  constructor(public shortService: ShortService, public router: Router, private route: ActivatedRoute) {

  }

  ngOnInit() {
    this.shortService.getUrlByShortUrl(this.route.snapshot.params['key']).subscribe(data=>{
      window.location.href = data.json().longUrl;
      },err=>{
    
      }
    )
  }


}
