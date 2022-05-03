import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Register } from './register';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  private url:string="http://localhost:8080/registers";
  constructor(private http: HttpClient) { }

  getArchivos():Observable<any>{
    return this.http.get<Register[]>(this.url);
  }
}
