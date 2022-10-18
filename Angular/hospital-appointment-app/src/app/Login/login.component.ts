import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Employee } from '../Domain/employee';
import { Patient } from '../Domain/patient';
import { EmployeeService } from '../Service/employee.service';
import { PatientService } from '../Service/patient.service';
import { Router } from '@angular/router';
import { environment } from 'src/environments/environment';

@Component({ templateUrl: 'login.component.html' })

export class LoginComponent implements OnInit{

    public employees: Employee[] = [];
    public patients: Patient[] = [];
  
    constructor(private employeeService: EmployeeService, private patientService: PatientService, private router: Router) { }

    ngOnInit(): void {
        this.employeeService.getEmployees().subscribe(
            (response: Employee[]) => {
              this.employees = response;
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            })

        this.patientService.getPatients().subscribe(
            (response: Patient[]) => {
                this.patients = response;
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            })
    }

    public verifyLogin(username: string, password: string): void{

        var valid:boolean = false;

        for (let i = 0; i < this.employees.length; i++) {
                if(this.employees[i].password == password && this.employees[i].employeeId == username){
                    this.router.navigateByUrl('/EmployeeMenu');
                    environment.employeeId = this.employees[i].employeeId;
                    valid = true;
                }
            }
             
        for (let i = 0; i < this.patients.length; i++) {
                if(this.patients[i].password == password && this.patients[i].patientID == username){
                    this.router.navigateByUrl('/PatientMenu');
                    environment.patientId = this.patients[i].patientID;
                    valid = true;
                }
            }

        if(!valid){
            alert("Incorrect Login Details")
        }   

    }
  
  }
  