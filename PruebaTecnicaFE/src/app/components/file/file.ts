import { Register } from "../register/register";

export class File {
    fileId: number;
    nameFile: string;
    totalCol: number;
    nameCol: string;
    totalRegisters: number;
    registers: Register[];

    constructor(_fileId: number, _nameFile: string, _totalCol: number, _nameCol: string, _totalRegisters:number, _registers:Register[]) {
        this.fileId = _fileId;
        this.nameFile = _nameFile;
        this.totalCol = _totalCol;
        this.nameCol = _nameCol;
        this.totalRegisters = _totalRegisters;
        this.registers = _registers;
    }

}
