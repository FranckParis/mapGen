import { Map } from '../shared/map';
import { MapService } from '../shared/map/map.service';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'random-map',
  templateUrl: './random-map.component.html',
  styleUrls: ['./random-map.component.css']
})

export class RandomMapComponent implements OnInit {

  grid: any;

  constructor(private mapService: MapService) {}

  ngOnInit() {
    this.mapService.getRandom().subscribe(data => {

          this.grid = new Map(
                      data.map,
                      data.length,
                      data.width,
                      data.cities,
                      data.citiesProba,
                      data.citiesIterNb,
                      data.forests,
                      data.forestsProba,
                      data.forestsIterNb,
                      data.water,
                      data.waterProba,
                      data.waterIterNb);
    });
  }
}
