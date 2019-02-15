export class Map {

  constructor(
    public map : any,
    public length: number,
    public width: number,
    public cities: boolean,
    public citiesProba: number,
    public citiesIterNb: number,
    public forests: boolean,
    public forestsProba: number,
    public forestsIterNb: number,
    public water: boolean,
    public waterProba: number,
    public waterIterNb: number
  ) {  }

}
