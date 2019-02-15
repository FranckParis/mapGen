import { Component } from '@angular/core';
import { Map } from '../shared/map';
import { MapService } from '../shared/map/map.service';
import { Subscription } from 'rxjs/internal/Subscription';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'request-map',
  templateUrl: './request-map.component.html',
  styleUrls: ['./request-map.component.css']
})
export class RequestMapComponent {

  sub: Subscription;
  map: any;
  ms: MapService;

  constructor(private mapService: MapService,
              private route: ActivatedRoute,
              private router: Router) {
    this.ms = mapService;
  }

  model = new Map(null, 12, 12, true, 3, 3, true, 3, 3, false, 3, 4);
  submitted = false;

  onSubmit(obj:any) {
      this.map = obj;
      console.log(this.map);
      this.ms.postRequest(this.map).subscribe(
        data => {
          console.log(data);
          this.ngOnInit(data);
        }
      )
  }

  ngOnInit(data : any){
    if(data != null){
      this.map = data;
    }
  }

  newMapRequest() {
    this.model = new Map(null, 12, 12, true, 3, 3, true, 3, 3, false, 3, 4);
    this.map = null;
  }
}
