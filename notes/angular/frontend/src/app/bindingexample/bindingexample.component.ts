import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-bindingexample',
  templateUrl: './bindingexample.component.html',
  styleUrls: ['./bindingexample.component.css']
})
export class BindingexampleComponent implements OnInit {

  type;
  constructor() { }

  ngOnInit(): void {
  }

  enter(){
    console.log("method called");
  }

  upload(file){
    console.log(file)
  }
}
