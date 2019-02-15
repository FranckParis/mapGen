import { MapService } from '../shared/map/map.service';
import { OnInit, Component } from '@angular/core';

@Component({
  selector: 'view-map',
  templateUrl: './view-map.component.html',
  styleUrls: ['./view-map.component.css']
})

export class ViewMapComponent implements OnInit {
  map: any;

  constructor(private mapService: MapService) { }

  ngOnInit() {
    this.mapService.get().subscribe(data => {
      this.map = data;
    });
  }
}
