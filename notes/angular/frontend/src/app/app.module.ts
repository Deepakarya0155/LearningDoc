import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { Home } from './home/home.component';
import { Backend } from './services/Backend';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import { BindingexampleComponent } from './bindingexample/bindingexample.component';
import { CustompipeExampleComponent } from './custompipe-example/custompipe-example.component'
import { Summary } from './custompipe-example/Summary';

@NgModule({
  declarations: [
    AppComponent,Home, BindingexampleComponent, CustompipeExampleComponent,Summary
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [Backend],
  bootstrap: [AppComponent]
})
export class AppModule { }
