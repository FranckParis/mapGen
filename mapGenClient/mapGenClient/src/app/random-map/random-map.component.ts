import { MapService } from '../shared/map/map.service';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'random-map',
  templateUrl: './random-map.component.html',
  styleUrls: ['./random-map.component.css']
})

export class RandomMapComponent implements OnInit {
  map: any;

  constructor(private mapService: MapService) { }

  ngOnInit() {
    this.mapService.getRandom().subscribe(data => {
      this.map = data;
    });
  }
}
