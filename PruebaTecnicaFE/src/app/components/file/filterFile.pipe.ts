import { Pipe, PipeTransform } from '@angular/core';
import { File } from './file';

@Pipe({
  name: 'filtroFile'
})
export class FilterFilePipe implements PipeTransform {

  transform(dataList: File[], arg: any): any {
    if(arg== '' || arg.length <1) return dataList;
    var resultData: File[] = [];
    for(const data of dataList){
      if(data.nameFile.toLowerCase().indexOf(arg.toLowerCase()) > -1){
        resultData.push(data);
      }else if(data.totalCol.toString().indexOf(arg) >-1){
        resultData.push(data);
      }else if(data.totalRegisters.toString().indexOf(arg) >-1){
        resultData.push(data);
      }
    }
    return resultData;
  }

}
