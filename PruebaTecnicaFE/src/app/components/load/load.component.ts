import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import swal from 'sweetalert2';
import { LoadService } from './load.service';

@Component({
  selector: 'app-load',
  templateUrl: './load.component.html',
  styleUrls: ['./load.component.css']
})
export class LoadComponent implements OnInit {
  private url: string = "http://localhost:8080/files";
  selectedFile: any;
  message2: string = "";

  constructor(private http: HttpClient, private router: Router,private loadService:LoadService) { }

  private httpHeaders=new HttpHeaders({'Content-type':'application/json'});

  public onFileChanged(event: any) {
    this.selectedFile = event.target.files[0];
    console.log('file', this.selectedFile);
  }

  load() {
    const uploadFileData = new FormData();
    uploadFileData.append('file', this.selectedFile, this.selectedFile.name);
    console.log(this.selectedFile.name);
    this.http.post<File>(`${this.url}/${"load"}`, uploadFileData, { observe: 'response' }).subscribe(
    (response) => {
      this.router.navigate(['/files'])
      console.log(response.status)
      if (response.status === 200) {
        console.log(response.status)
        swal.fire({
          title: 'Archivo y sus registros cargados con éxito',
          text:'Mensaje Servidor:' + JSON.stringify(response.body), 
          icon:'success',
          timer: 8000
          })
        this.message2 = 'Image uploaded successfully';
      }
    },
      err => {
        this.router.navigate(['']) 
        swal.fire({
          title:'El archivo no se pudo cargar correctamente',
          html:'Ten cuidado:<br> 1. No se puede cargar documentos con un nombre de archivo ya existente<br> 2. No se puede cargar documentos que tengan un formato diferente a .CSV',
          icon:'error',
          timer: 8000})
        this.message2 = 'Image not uploaded successfully';
    }
    
    );
  }

  save(){
    this.loadService.save(this.selectedFile)
  }
  ngOnInit(): void {
  }

}
