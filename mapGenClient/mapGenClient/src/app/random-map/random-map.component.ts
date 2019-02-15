import { MapService } from '../shared/map/map.service';
import { GridComponent } from '../grid/grid.component';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'random-map',
  templateUrl: './random-map.component.html',
  styleUrls: ['./random-map.component.css']
})

export class RandomMapComponent implements OnInit {
  map: any;
  grid: GridComponent;

  constructor(private mapService: MapService) { }

  ngOnInit() {
    this.mapService.getRandom().subscribe(data => {
      this.map = data;
      this.grid = new GridComponent(this.map);
    });
  }
}
