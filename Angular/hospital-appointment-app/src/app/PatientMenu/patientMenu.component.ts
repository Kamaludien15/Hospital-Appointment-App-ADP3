import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { Appointment } from '../Domain/appointment';
import { Employee } from '../Domain/employee';
import { Patient } from '../Domain/patient';
import { AppointmentService } from '../ServicePatient/appointment.service';
import { PatientService } from '../ServicePatient/patient.service';
import { HospitalService } from '../ServicePatient/hospital.service';
import { Hospital } from '../Domain/hospital';
import { PrescriptionService } from '../ServicePatient/prescription.service';
import { Prescription } from '../Domain/prescription';
import { Procedure } from '../Domain/procedure';
import { ProcedureService } from '../ServicePatient/procedure.service';
import {v4 as uuids4} from 'uuid';
import { Medicine } from '../Domain/medicine';
import { MedicineService } from '../ServicePatient/medicine.service';

@Component({ templateUrl: 'patientMenu.component.html' })
export class PatientMenuComponent implements OnInit{

    constructor(private procedureService: ProcedureService,private prescriptionService: PrescriptionService,private hospitalService: HospitalService,private appointmentService: AppointmentService, private patientService: PatientService, private medicineService: MedicineService) { }

    public appointments: Appointment[] = [];
    public patients: Patient[] = [];
    public hospitals: Hospital[] = [];
    public prescriptions: Prescription[] = [];
    public procedures: Procedure[] = [];
    public medicines: Medicine[] = [];
    public generatedId: String | undefined;
    public editAppointment: Appointment | undefined;
    public deleteAppointment: Appointment | undefined;
    public editProcedure: Procedure | undefined;
    public deleteProcedure: Procedure | undefined;
    public editMedicine: Medicine | undefined;
    public deleteMedicine: Medicine | undefined;
    public editPatient: Patient | undefined;
    public deletePatient: Patient | undefined;

    ngOnInit(): void {
        //Fetching data to call from later
        this.appointmentService.getAppointments().subscribe(
            (response: Appointment[]) => {
              for (let i = 0; i < response.length; i++) {
                if(response[i].patient.patientID == environment.patientId){
                    this.appointments.push(response[i]) 
                }
            }
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            })

        this.patientService.getPatients().subscribe(
            (response: Patient[]) => {
                for (let i = 0; i < response.length; i++) {
                    if(response[i].patientID == environment.patientId){
                        this.patients.push(response[i]) 
                    }
                }
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            })

        this.hospitalService.getHospitals().subscribe(
            (response: Hospital[]) => {
                this.hospitals = response;
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            })
        this.prescriptionService.getPrescriptions().subscribe(
            (response: Prescription[]) => {
                this.prescriptions = response;
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            })
        this.procedureService.getProcedures().subscribe(
            (response: Procedure[]) => {
                this.procedures = response;
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            })

        this.medicineService.getMedicine().subscribe(
            (response: Medicine[]) => {
                this.medicines = response;
            },
            (error: HttpErrorResponse) => {
                alert(error.message);
            })

    }

    //Generating Id
    public generateId(): void{
        let id = uuids4();
        this.generatedId = id;
    }
    

    //Display variables
    public showAppointment = false;
    public showPatients = false;
    public showEmployees = false;
    public showMedicines = false;
    public showProcedures = false;

    //Hide All
    public hideAll(): void{
        this.showAppointment = false;
        this.showPatients = false;
        this.showEmployees = false;
        this.showMedicines = false;
        this.showProcedures = false;
    }  

    //Appointment//////////////////////////////////////////////////
    public displayAppointment(): void{
        this.hideAll();
        this.showAppointment = true;
    }   

    public onOpenModalAppointment( mode: string, appointment?: Appointment): void {
        const container = document.getElementById('appointment-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addAppointmentModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editAppointment = appointment;
        console.log(this.editAppointment);
        button.setAttribute('data-target', '#updateAppointmentModal');
        }
        if (mode === 'delete') {
        this.deleteAppointment = appointment;
        button.setAttribute('data-target', '#deleteAppointmentModal');
        }
        container?.appendChild(button);
        button.click();
    }


    //Patients/////////////////////////////////////////////////////
    public displayPatients(): void{
        this.hideAll();
        this.showPatients = true;
    }

    public onEditPatient(patient: Patient): void{
        
        this.patientService.updatePatient(patient).subscribe(
            (response: Patient) => {

                //Reloading Patient cards
                this.patientService.getPatients().subscribe(
                    (response: Patient[]) => {
                        this.patients = [];
                        for (let i = 0; i < response.length; i++) {
                            if(response[i].patientID == environment.patientId){
                                this.patients.push(response[i]) 
                            }
                        }  
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


    
    public onOpenModalPatient( mode: string, patient?: Patient): void {
        const container = document.getElementById('patient-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'edit') {
        this.editPatient = patient;
        console.log(this.editPatient);
        button.setAttribute('data-target', '#updatePatientModal');
        }
        container?.appendChild(button);
        button.click();
    }
    


    //Procedure/////////////////////////////////////////////////////
    public displayProcedures(): void{
        this.hideAll();
        this.showProcedures = true;
    }

    public onOpenModalProcedure( mode: string, procedure?: Procedure): void {
        const container = document.getElementById('procedure-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addProcedureModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editProcedure = procedure;
        console.log(this.editProcedure);
        button.setAttribute('data-target', '#updateProcedureModal');
        }
        if (mode === 'delete') {
        this.deleteProcedure = procedure;
        button.setAttribute('data-target', '#deleteProcedureModal');
        }
        container?.appendChild(button);
        button.click();
    }


    //Medicine/////////////////////////////////////////////////////
    public displayMedicines(): void{
        this.hideAll();
        this.showMedicines = true;
    }

    public onOpenModalMedicine( mode: string, medicine?: Medicine): void {
        const container = document.getElementById('medicine-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addMedicineModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editMedicine = medicine;
        console.log(this.editMedicine);
        button.setAttribute('data-target', '#updateMedicineModal');
        }
        if (mode === 'delete') {
        this.deleteMedicine = medicine;
        button.setAttribute('data-target', '#deleteMedicineModal');
        }
        container?.appendChild(button);
        button.click();
    }

    
}