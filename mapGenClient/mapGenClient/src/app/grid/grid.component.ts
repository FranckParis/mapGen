import { Component } from '@angular/core';
import { Map } from '../shared/map';

@Component({
  selector: 'grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.css']
})
export class GridComponent {

  map: any;

  constructor(map:Map) {
    this.map = map;
  }

  ngOnInit(data : Map){
    if(data != null){
      this.map = data;
    }
  }
}
