import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Gender } from '../Domain/gender';
import { GenderService } from '../Service/gender.service';
import {v4 as uuids4} from 'uuid';

@Component({
    selector: 'app-gender',
    templateUrl: 'genderMenu.component.html',
    styleUrls:['genderMenu.component.css']
 })

 export class GenderMenuComponent implements OnInit {

    constructor(private genderService: GenderService) { }

    public genders: Gender[] = [];
    public generatedId: String = this.generateId();

    /*Variables interpolated inside gender navigation to manipulate display*/
    public viewGenders: String = "d-none";
    public createGender: String = "d-none";
    public updateGender: String = "d-none";

    ngOnInit(): void {

        //Fetching data to call from later
        this.genderService.getGenders().subscribe(
            (response: Gender[]) => {
                this.genders = response;
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

/*Gender navigation methods*/
    public createGenders():void{
      this.createGender = "d-block";
      this.viewGenders  = "d-none";
      this.updateGender = "d-none";
    }

    public viewGender():void{
        this.createGender = "d-none";
        this.viewGenders  = "d-block";
        this.updateGender = "d-none";
    }

    public updateGenders():void{
        this.createGender = "d-none";
        this.viewGenders  = "d-none";
        this.updateGender = "d-block";
    }
/*------*/

    public onCreateGender(createGenderForm: NgForm): void{

        this.genderService.addGender(createGenderForm.value).subscribe(
            (response: Gender) => {

                //Reloading Departments
                this.genderService.getGenders().subscribe(
                    (response: Gender[]) => {

                      alert("Gender created, click view genders to confirm");
                      this.genders = response;
                      createGenderForm.reset();
                      this.generatedId = this.generateId();
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      createGenderForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public deleteGender(genderId?: string): void{

            this.genderService.deleteGender(genderId).subscribe(

                (response: void) => {

                  //Reloading genders
                  this.genderService.getGenders().subscribe(
                        (response: Gender[]) => {
                          this.genders = response;
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

        public onUpdateGender(updateGenderForm: NgForm): void{

            this.genderService.updateGender(updateGenderForm.value).subscribe(
                (response: Gender) => {

                    //Reloading genders
                    this.genderService.getGenders().subscribe(
                        (response: Gender[]) => {

                          alert("Gender updated, click view genders to confirm");
                          this.genders = response;
                          updateGenderForm.reset();

                        },
                        (error: HttpErrorResponse) => {
                          alert(error.message);
                          updateGenderForm.reset();
                        })
                },
                (error: HttpErrorResponse) => {
                    alert(error.message)
                }
            );
        }

 }
