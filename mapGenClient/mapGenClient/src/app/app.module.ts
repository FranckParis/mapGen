import { MapService } from './shared/map/map.service';

import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';

import { RandomMapComponent } from './random-map/random-map.component';
import { RequestMapComponent } from './request-map/request-map.component';
import { GridComponent } from './grid/grid.component';


import { Routes, RouterModule } from '@angular/router';

const appRoutes: Routes = [
  { path: '', redirectTo: '/app-root', pathMatch: 'full' },
  {
    path: 'random-map',
    component: RandomMapComponent
  },
  {
    path: 'request-map',
    component: RequestMapComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    RandomMapComponent,
    RequestMapComponent,
    GridComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
  ],
  providers: [MapService],
  bootstrap: [AppComponent]
})
export class AppModule {};
