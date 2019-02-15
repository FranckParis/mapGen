import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class MapService {

  constructor(private http: HttpClient) {
  }

  getRandom(): Observable<any> {
    return this.http.get('//localhost:8080/randomMap');
  }

  postRequest(map:any): Observable<any> {
    return this.http.post('//localhost:8080/requestMap', map);
  }
}
