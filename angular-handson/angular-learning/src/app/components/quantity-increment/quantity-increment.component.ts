import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-quantity-increment',
  templateUrl: './quantity-increment.component.html',
  styleUrls: ['./quantity-increment.component.css']
})
export class QuantityIncrementComponent implements OnInit {
  displayValue: number;
  value: number;
  flag : Boolean = false;
  constructor() {
    this.displayValue = 0;
    this.value = 0;
    
   }

  ngOnInit(): void {
    if(this.value==0){
      this.flag=true;
    }
    
  }
  add(){
    
    this.displayValue += 1;
   }
   increase(){
    this.flag=false;
    this.value+=1;
   }
   decrease(){
     this.value-=1;
     if(this.value==0){
      this.flag=true;
    }
   }
}
