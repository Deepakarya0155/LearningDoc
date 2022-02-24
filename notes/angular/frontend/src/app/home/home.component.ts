import { HttpClient, HttpEventType } from "@angular/common/http";
import { Component } from "@angular/core";
import { Backend } from "../services/Backend";

@Component({
    selector:"home",
    templateUrl:"./home.component.html",
    styleUrls:["./home.component.css"]
})
export class Home{

    constructor(private http:HttpClient){
      
    }


    public upload(fl){
        console.log(fl.files)
        let formdata=new FormData();
        formdata.set("files",fl.files[0]);
        this.http.post("http://localhost:8080/upload",formdata,
        {reportProgress:true,observe:'events'})
        .subscribe((resp:any)=>{
            if(resp.type==HttpEventType.UploadProgress){
                console.log((resp.loaded/resp.total )*100)
            }
            if(resp.type==HttpEventType.Response){
                console.log("success");
            }
        });
    }
    
}