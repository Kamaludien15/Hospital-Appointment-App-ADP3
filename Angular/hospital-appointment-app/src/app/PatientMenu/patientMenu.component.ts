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
import { LocationService } from '../Service/location.service';
import { Location } from '../Domain/location';
import Swal from 'sweetalert2'

@Component({ templateUrl: 'patientMenu.component.html' })
export class PatientMenuComponent implements OnInit{

    constructor(private locationService: LocationService,private procedureService: ProcedureService,private prescriptionService: PrescriptionService,private hospitalService: HospitalService,private appointmentService: AppointmentService, private patientService: PatientService, private medicineService: MedicineService) { }

    public appointments: Appointment[] = [];
    public patients: Patient[] = [];
    public hospitals: Hospital[] = [];
    public prescriptions: Prescription[] = [];
    public procedures: Procedure[] = [];
    public medicines: Medicine[] = [];
    public locations: Location[] = [];
    public generatedId: String | undefined;
    public editAppointment: Appointment | undefined;
    public deleteAppointment: Appointment | undefined;
    public editProcedure: Procedure | undefined;
    public deleteProcedure: Procedure | undefined;
    public editMedicine: Medicine | undefined;
    public deleteMedicine: Medicine | undefined;
    public editPrescription: Prescription | undefined;
    public deletePrescription: Prescription | undefined;
    public editEmployee: Employee | undefined;
    public deleteEmployee: Employee | undefined;
    public editPatient: Patient | undefined;
    public deletePatient: Patient | undefined;
    public editHospital: Hospital | undefined;
    public deleteHospital: Hospital | undefined;
    public editLocation: Location | undefined;
    public deleteLocation: Location | undefined;


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
    
            this.locationService.getLocations().subscribe(
                (response: Location[]) => {
                    this.locations = response;
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
    public showPrescriptions = false;
    public showLocation = false;  
    public showHospital = false;

    //Hide All
    public hideAll(): void{
        this.showAppointment = false;
        this.showPatients = false;
        this.showEmployees = false;
        this.showMedicines = false;
        this.showProcedures = false;
        this.showPrescriptions  = false;
        this.showLocation = false;
        this.showHospital = false;
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
                        Swal.fire({
                            position: 'top-end',
                            icon: 'success',
                            title: 'Patient has been edited',
                            showConfirmButton: false,
                            timer: 1500
                          })
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

    //Hospital//////////////////////////////////////////////////
    public displayHospital(): void{
        this.hideAll();
        this.showHospital = true; 
    }   

 
    
    public onOpenModalHospital( mode: string, hospital?: Hospital): void {
        const container = document.getElementById('hospital-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        
        container?.appendChild(button);
        button.click();
    }  

    //Location//////////////////////////////////////////////////
    public displayLocation(): void{
        this.hideAll();
        this.showLocation = true;
    }   

    

    

    public onOpenModalLocation( mode: string, location?: Location): void {
        const container = document.getElementById('location-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        
        container?.appendChild(button);
        button.click();
    }

    //Prescription//////////////////////////////////////////////////
    public displayPrescription(): void{
        this.hideAll();
        this.showPrescriptions = true;
    }   


    public onOpenModalPrescription( mode: string, prescription?: Prescription): void {
        const container = document.getElementById('prescription-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
       
        container?.appendChild(button);
        button.click();
    }

    
}