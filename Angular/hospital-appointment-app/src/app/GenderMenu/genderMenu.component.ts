import { Component, OnInit } from '@angular/core';
import { HttpErrorResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { Gender } from '../Domain/gender';
import { GenderService } from '../Service/gender.service';
import {v4 as uuids4} from 'uuid';
import Swal from 'sweetalert2'

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
    public removeGender: String = "d-none";
    public editGenderId: String = "";
    public selectedGender?: Gender;
    public deletedGenderId?:String;

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
      this.removeGender = "d-none";
    }

    public viewGender():void{
        this.createGender = "d-none";
        this.viewGenders  = "d-block";
        this.updateGender = "d-none";
        this.removeGender = "d-none";
    }

    public updateGenders():void{
        this.createGender = "d-none";
        this.viewGenders  = "d-none";
        this.updateGender = "d-block";
        this.removeGender = "d-none";
    }

    public hideAll(): void{
        this.createGender = "d-none";
        this.viewGenders  = "d-none";
        this.updateGender = "d-none";
        this.removeGender = "d-none";
    }

    public deleteGenders(id:String):void{
      this.createGender = "d-none";
      this.viewGenders  = "d-none";
      this.updateGender = "d-none";
      this.removeGender = "d-block";
      this.deletedGenderId = id;
    }
/*------*/

public updateGenderById(id: String):void{
    this.editGenderId = id;
    this.selectedGender = this.genders.find(gender => gender.genderID === id);
    this.updateGenders();
  }

    public onCreateGender(createGenderForm: NgForm): void{

        this.genderService.addGender(createGenderForm.value).subscribe(
            (response: Gender) => {

                //Reloading Departments
                this.genderService.getGenders().subscribe(
                    (response: Gender[]) => {

                      this.genders = response;
                      createGenderForm.reset();
                      this.generatedId = this.generateId();
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      createGenderForm.reset();
                    })
                    Swal.fire({
                      position: 'top-end',
                      icon: 'success',
                      title: 'Gender has been saved',
                      showConfirmButton: false,
                      timer: 1500
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public deleteGender(genderId?: String): void{

            this.genderService.deleteGender(genderId).subscribe(

                (response: void) => {

                  this.hideAll();
                  //Reloading genders
                  this.genderService.getGenders().subscribe(
                        (response: Gender[]) => {
                          this.genders = response;
                        },
                        (error: HttpErrorResponse) => {
                          alert(error.message);
                        })
                        Swal.fire({
                          position: 'top-end',
                          icon: 'success',
                          title: 'Gender has been deleted',
                          showConfirmButton: false,
                          timer: 1500
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

                          this.genders = response;
                          updateGenderForm.reset();

                        },
                        (error: HttpErrorResponse) => {
                          alert(error.message);
                          updateGenderForm.reset();
                        })
                        Swal.fire({
                          position: 'top-end',
                          icon: 'success',
                          title: 'Gender has been edited',
                          showConfirmButton: false,
                          timer: 1500
                        })
                },
                (error: HttpErrorResponse) => {
                    alert(error.message)
                }
            );
        }

 }
