import { Pipe,PipeTransform } from "@angular/core";

@Pipe({
    name:"summary"
})
export class Summary implements PipeTransform{
    
    transform(value: string, limit?:number) {
       return value.substr(0,limit);
    }

}