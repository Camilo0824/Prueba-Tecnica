import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class LoadService {

  private url: string = "http://localhost:8080/files/readsave";

  constructor(private http: HttpClient) { }

  save(selectedFile:any){
    const uploadFileData = new FormData();
    uploadFileData.append('file', selectedFile, selectedFile.name);
    console.log(selectedFile.name);
    this.http.get(`${this.url}/${selectedFile.name}`);
  }
  
  
}