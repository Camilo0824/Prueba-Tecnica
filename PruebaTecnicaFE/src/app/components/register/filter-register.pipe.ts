import { Pipe, PipeTransform } from '@angular/core';
import { Register } from './register';

@Pipe({
  name: 'filterRegister'
})
export class FilterRegisterPipe implements PipeTransform {

  transform(dataList: Register[], arg: any): any {
    if (arg == '' || arg.length < 1) return dataList;
    var resultData: Register[] = [];
    for (const data of dataList) {
      if (data.file.nameFile.toLowerCase().indexOf(arg.toLowerCase()) > -1) {
        resultData.push(data);
      }else if (data.registerId.toString().indexOf(arg.toLowerCase()) > -1) {
        resultData.push(data);
      }
    }
    return resultData;
  }
}
