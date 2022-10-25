import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Department } from '../Domain/department';
import { DepartmentService } from '../Service/department.service';
import {v4 as uuids4} from 'uuid';

@Component({
    selector: 'app-department',
    templateUrl: 'departmentMenu.component.html',
    styleUrls:['departmentMenu.component.css']
 })

export class DepartmentMenuComponent implements OnInit {

    constructor(private departmentService: DepartmentService) { }

    public departments: Department[] = [];
    public generatedId: String = this.generateId();
    /*Variables assigned to bootstrap display attributes*/
    public viewDepartments: String = "d-none";
    public createDepartments: String = "d-none";
    public updateDepartments: String = "d-none";
    public editDepartmentId: String = "";
    public selectedDepartment?: Department;

    ngOnInit(): void {

        //Fetching data to call from later
        this.departmentService.getDepartments().subscribe(
            (response: Department[]) => {
                this.departments = response;
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            })

    }

    //Generate department Id
    public generateId(): String{
        let id = uuids4();
        return id;
    }

  public hideAll(): void{
  this.createDepartments = "d-none";
  this.viewDepartments  = "d-none";
  this.updateDepartments = "d-none";
  }  

  /*Methods for displaying department menus*/
    public createDepartment():void{
      this.createDepartments = "d-block";
      this.viewDepartments  = "d-none";
      this.updateDepartments = "d-none";
    }

    public viewDepartment():void{
      this.viewDepartments  = "d-block";
      this.createDepartments = "d-none";
      this.updateDepartments = "d-none";
    }

    public updateDepartment():void{
      this.updateDepartments = "d-block";
      this.createDepartments = "d-none";
      this.viewDepartments  = "d-none";
    }

    public updateDepartmentById(id: String):void{
      this.editDepartmentId = id;
      this.selectedDepartment = this.departments.find(dep => dep.departmentId === id);
      this.updateDepartment();
    } 

    public onCreateDepartment(createDepartmentForm: NgForm): void{

        this.departmentService.addDepartment(createDepartmentForm.value).subscribe(
            (response: Department) => {

                //Reloading Departments
                this.departmentService.getDepartments().subscribe(
                    (response: Department[]) => {

                      alert("Department created, click view department to confirm");
                      this.departments = response;
                      createDepartmentForm.reset();
                      this.generatedId = this.generateId();

                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      createDepartmentForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );

    }

    public onUpdateDepartment(updateDepartmentForm: NgForm): void{

      this.departmentService.addDepartment(updateDepartmentForm.value).subscribe(
          (response: Department) => {

              //Reloading Departments
              this.departmentService.getDepartments().subscribe(
                  (response: Department[]) => {

                    alert("Department updated, click view department to confirm");
                    this.departments = response;
                    updateDepartmentForm.reset();

                  },
                  (error: HttpErrorResponse) => {
                    alert(error.message);
                    updateDepartmentForm.reset();
                  })
          },
          (error: HttpErrorResponse) => {
              alert(error.message)
          }
      );
  }

    public deleteDepartment(departmentId?: string): void{

            this.departmentService.deleteDepartment(departmentId).subscribe(

                (response: void) => {

                  //Reloading Departments
                  this.departmentService.getDepartments().subscribe(
                        (response: Department[]) => {
                          this.departments = response;
                        },
                        (error: HttpErrorResponse) => {
                          alert(error.message);
                        })
                },
                (error: HttpErrorResponse) => {
                    alert(error.message)
                }
            );
        }

}
