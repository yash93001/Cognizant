import { Component, OnInit } from '@angular/core';

import { employee } from 'src/app/employee';
import { department } from 'src/app/Department';

@Component({
  selector: 'app-edit-emp-template-drive',
  templateUrl: './edit-emp-template-drive.component.html',
  styleUrls: ['./edit-emp-template-drive.component.css']
})
export class EditEmpTemplateDriveComponent implements OnInit {
  name: string = "";
  salary: number = 0;
  employee = new employee(this.name,this.salary);
  departments: department[];


  constructor() {
    this.departments = [

      { id: 1, name: "Payroll" },
      
      { id: 2, name: "Internal" },
      
      { id: 3, name: "HR" }
      
      ];
   }

  ngOnInit(): void {
  }
  

}
