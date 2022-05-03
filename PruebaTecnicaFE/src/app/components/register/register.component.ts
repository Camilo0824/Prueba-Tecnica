import { Component, OnInit } from '@angular/core';
import { Register } from './register';
import { RegisterService } from './register.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  constructor(private registerService: RegisterService) { }
  
  registers: Array<any> = [];
  filterDataRegister = '';
  
  ngOnInit(): void {
    this.registerService.getArchivos().subscribe(registers=>this.registers = registers)
  }

}
