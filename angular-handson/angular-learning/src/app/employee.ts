import { mainModule } from "process";
import { department } from "./Department";
import { skills } from "./skills";
export class employee {
    public id: string = "3";
    public name: string = "John";
    public salary: number = 10000;
    public permanent: boolean = true;
    public department: department = {
      "id" : 1,
      "name" : "Payroll"
    };
    public skills: skills[] = [{
      "id":1, 
      "name": "HTML"
    },
    {
      "id":2, 
      "name": "CSS"
    },{
      "id":3, 
      "name": "JavaScript"
    },
  ]
    public dateOfBirth: string = "2019-04-20T18:30:00.000Z";

    constructor(
      name?: string,
      salary?: number,
    ) {

      }
    
  
  }