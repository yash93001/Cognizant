import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { Routes, RouterModule } from '@angular/router';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EditEmpTemplateDriveComponent } from './components/edit-emp-template-drive/edit-emp-template-drive.component';
import { ViewEmpComponent } from './components/view-emp/view-emp.component';
import { EditEmpComponent } from './components/edit-emp/edit-emp.component';
import { QuantityIncrementComponent } from './components/quantity-increment/quantity-increment.component';

const routes: Routes = [
  {path:'View-Employee',component: ViewEmpComponent},
  {path:'Edit-Employee',component: EditEmpComponent},
  {path:'quantity-increment',component: QuantityIncrementComponent},
  {path:'Edit-Employee-template',component: EditEmpTemplateDriveComponent},
];

@NgModule({
  declarations: [
    AppComponent,
    EditEmpTemplateDriveComponent,
    ViewEmpComponent,
    EditEmpComponent,
    QuantityIncrementComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule, RouterModule.forRoot(routes, {enableTracing: true}), 
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
