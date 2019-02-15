import { Component } from '@angular/core';
import { MapParams } from '../shared/map-params';
import { ActivatedRoute, Router } from '@angular/router';
import { MapService } from '../shared/map/map.service';
import { Subscription } from 'rxjs/internal/Subscription';

@Component({
  selector: 'request-map',
  templateUrl: './request-map.component.html',
  styleUrls: ['./request-map.component.css']
})
export class RequestMapComponent {

  sub: Subscription;
  map: any;

  constructor(private route: ActivatedRoute,
              private router: Router,
              private mapService: MapService) {
  }

  model = new MapParams(12, 12, true, 3, 3, true, 3, 3, false, 3, 4);
  submitted = false;

  onSubmit() {

  }

  gotoList() {
    this.router.navigate(['/view-map']);
  }

  newMapRequest() {
    this.model = new MapParams(12, 12, true, 3, 3, true, 3, 3, false, 3, 4);
  }
}
