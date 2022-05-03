import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FileComponent } from './components/file/file.component';
import { FileService } from './components/file/file.service';
import { FilterFilePipe } from './components/file/filterFile.pipe';
import { RegisterComponent } from './components/register/register.component';
import { FilterRegisterPipe } from './components/register/filter-register.pipe';
import { LoadComponent } from './components/load/load.component';


@NgModule({
  declarations: [
    AppComponent,
    FileComponent,
    FilterFilePipe,
    RegisterComponent,
    FilterRegisterPipe,
    LoadComponent
  ],
  
  imports: [
    RouterModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
  ],

  providers: [
    FileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
