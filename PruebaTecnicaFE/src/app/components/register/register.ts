import { File } from "../file/file";

export class Register {
    registerId:number;
    registerData:string;
    file:File;

    constructor(_registerId:number,_registerData:string,_file:File){
        this.registerId = _registerId;
        this.registerData = _registerData;
        this.file = _file; 
    }
}
