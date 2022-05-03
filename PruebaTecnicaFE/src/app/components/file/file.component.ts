import { Component, OnInit } from '@angular/core';
import { FileService } from './file.service';

@Component({
  selector: 'app-File',
  templateUrl: './file.component.html',
  styleUrls: ['./file.component.css']
})
export class FileComponent implements OnInit {

  constructor(private fileService: FileService) { }

  filterDataFile = '';

  files: Array<any> = [];
  totalPages: Array<number> = [];
  page = 0;
  size = 4;
  order = 'fileId';
  asc = false;

  isFirst = false;
  isLast = false;

  ngOnInit(): void {
    this.cargarArchivos();
  }

  cargarArchivos() {
    this.fileService.getArchivos(this.page, this.size, this.order, this.asc).subscribe(
      data => {
        this.files = data.content;
        this.isFirst = data.firts;
        this.isLast = data.last;
        this.totalPages = new Array(data['totalPages'])
        console.log(data);
      },
      err => {
        console.log(err.error)
      }
    );
  }

  sort(): void {
    this.asc = !this.asc;
    this.cargarArchivos();
  }

  rewind(): void {
    if (!this.isFirst) {
      this.page--;
      this.cargarArchivos();
    }
  }

  forward(): void {
    if (!this.isLast) {
      this.page++;
      this.cargarArchivos();
    }
  }

  setPage(page: number): void {
    this.page = page;
    this.cargarArchivos();
  }

  setOrder(order: string) {
    this.order = order;
    this.cargarArchivos();
  }

}
