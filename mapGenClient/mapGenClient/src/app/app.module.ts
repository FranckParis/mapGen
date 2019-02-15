import { MapService } from './shared/map/map.service';

import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule }   from '@angular/forms';

import { AppComponent } from './app.component';

import { ViewMapComponent } from './view-map/view-map.component';
import { RequestMapComponent } from './request-map/request-map.component';
import { Routes, RouterModule } from '@angular/router';

const appRoutes: Routes = [
  { path: '', redirectTo: '/request-map', pathMatch: 'full' },
  {
    path: 'view-map',
    component: ViewMapComponent
  },
  {
    path: 'request-map',
    component: RequestMapComponent
  }
];

@NgModule({
  declarations: [
    AppComponent,
    ViewMapComponent,
    RequestMapComponent
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
