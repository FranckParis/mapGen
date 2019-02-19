import { Map } from '../shared/map';
import { Component, Input } from '@angular/core';

@Component({
  selector: 'grid',
  templateUrl: './grid.component.html',
  styleUrls: ['./grid.component.css']
})

export class GridComponent {

  @Input() map: Map;
  
  constructor(){}

  ngOnInit(){
    console.log("Initialized");
  }

  ngOnChanges(){
  }

  iterateOverMap(){
  }
}
