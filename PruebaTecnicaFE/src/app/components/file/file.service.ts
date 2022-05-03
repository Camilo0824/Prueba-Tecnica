import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { Observable } from 'rxjs';
import { File } from './file';

@Injectable({
  providedIn: 'root'
})

export class FileService {

  private url:string="http://localhost:8080/files?";

  constructor( private http:HttpClient) { }

  getArchivos(page: number, size:number, order:string, asc:boolean):Observable<any>{
    return this.http.get<File[]>(this.url+`page=${page}&size=${size}&order=${order}&asc=${asc}`);
  }
}
