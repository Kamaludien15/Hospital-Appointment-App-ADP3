import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { appRoutingModule } from './app.routing';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './Login';
import { EmployeeMenuComponent } from './EmployeeMenu';
import { PatientMenuComponent } from './PatientMenu';
import { DepartmentMenuComponent } from './DepartmentMenu';
import { GenderMenuComponent } from './GenderMenu';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    EmployeeMenuComponent,
    PatientMenuComponent,
    DepartmentMenuComponent,
    GenderMenuComponent
  ],
  imports: [
    appRoutingModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
