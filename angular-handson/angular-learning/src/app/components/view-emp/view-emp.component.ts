import { Component, OnInit } from '@angular/core';
import { employee } from 'src/app/employee';

@Component({
  selector: 'app-view-emp',
  templateUrl: './view-emp.component.html',
  styleUrls: ['./view-emp.component.css']
})
export class ViewEmpComponent implements OnInit {
  employee = new employee();
  constructor() { }

  ngOnInit(): void {
  }
  
}
