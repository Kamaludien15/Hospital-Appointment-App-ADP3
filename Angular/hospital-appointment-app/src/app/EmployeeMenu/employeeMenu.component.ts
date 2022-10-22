import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { environment } from 'src/environments/environment';
import { Appointment } from '../Domain/appointment';
import { Employee } from '../Domain/employee';
import { Patient } from '../Domain/patient';
import { AppointmentService } from '../Service/appointment.service';
import { EmployeeService } from '../Service/employee.service';
import { PatientService } from '../Service/patient.service';
import { HospitalService } from '../Service/hospital.service';
import { Hospital } from '../Domain/hospital';
import { PrescriptionService } from '../Service/prescription.service';
import { Prescription } from '../Domain/prescription';
import { Procedure } from '../Domain/procedure';
import { ProcedureService } from '../Service/procedure.service';
import { Medicine } from '../Domain/medicine';
import { MedicineService } from '../Service/medicine.service';
import {v4 as uuids4} from 'uuid';

@Component({ templateUrl: 'employeeMenu.component.html' })
export class EmployeeMenuComponent implements OnInit{

    constructor(private procedureService: ProcedureService,private prescriptionService: PrescriptionService,private hospitalService: HospitalService,private appointmentService: AppointmentService,private medicineService: MedicineService, private employeeService: EmployeeService, private patientService: PatientService) { }

    public appointments: Appointment[] = [];
    public employees: Employee[] = [];
    public patients: Patient[] = [];
    public hospitals: Hospital[] = [];
    public medicines: Medicine[] = [];
    public prescriptions: Prescription[] = [];
    public procedures: Procedure[] = [];
    public generatedId: String | undefined;
    public editAppointment: Appointment | undefined;
    public deleteAppointment: Appointment | undefined;
    public editPrescription: Prescription | undefined;
    public deletePrescription: Prescription | undefined;

    ngOnInit(): void {
        //Fetching data to call from later
        this.appointmentService.getAppointments().subscribe(
            (response: Appointment[]) => {
              for (let i = 0; i < response.length; i++) {
                if(response[i].employee.employeeId == environment.employeeId){
                    this.appointments.push(response[i]) 
                }
            }
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            })

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
    public showPrescription = false;

    //Hide All
    public hideAll(): void{
        this.showAppointment = false;
        this.showPatients = false;
        this.showEmployees = false;
        this.showPrescription = false;
    }  

    //Appointment//////////////////////////////////////////////////
    public displayAppointment(): void{
        this.hideAll();
        this.showAppointment = true;
    }   

    public onAddAppointment(addAppointmentForm: NgForm): void{
        document.getElementById('add-appointment-form')?.click();
        this.appointmentService.addAppointment(addAppointmentForm.value).subscribe(
            (response: Appointment) => {

                //Reloading Appointment cards
                this.appointmentService.getAppointments().subscribe(
                    (response: Appointment[]) => {
                      this.appointments = [];
                      for (let i = 0; i < response.length; i++) {
                        if(response[i].employee.employeeId == environment.employeeId){
                            this.appointments.push(response[i]) 
                        }
                        addAppointmentForm.reset();
                    }
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addAppointmentForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public onEditAppointment(appointment: Appointment): void{
        
        let patientId = String(appointment.patient);
        for(let i = 0; i < this.patients.length; i++){
            if(patientId == this.patients[i].patientID){
                appointment.patient = this.patients[i];
            }
        }

        let hospitalId = String(appointment.hospital);
        for(let i = 0; i < this.hospitals.length; i++){
            if(hospitalId == this.hospitals[i].hospitalID){
                appointment.hospital = this.hospitals[i];
            }
        }

        let employeeId = String(appointment.employee);
        for(let i = 0; i < this.employees.length; i++){
            if(employeeId == this.employees[i].employeeId){
                appointment.employee = this.employees[i];
            }
        }

        let prescriptionId = String(appointment.prescription);
        for(let i = 0; i < this.prescriptions.length; i++){
            if(prescriptionId == this.prescriptions[i].scriptRef){
                appointment.prescription = this.prescriptions[i];
            }
        }

        let procedureId = String(appointment.procedure);
        for(let i = 0; i < this.procedures.length; i++){
            if(procedureId == this.procedures[i].procedureID){
                appointment.procedure = this.procedures[i];
            }
        }
        

        this.appointmentService.updateAppointment(appointment).subscribe(
            (response: Appointment) => {

                //Reloading Appointment cards
                this.appointmentService.getAppointments().subscribe(
                    (response: Appointment[]) => {
                      this.appointments = [];
                      for (let i = 0; i < response.length; i++) {
                        if(response[i].employee.employeeId == environment.employeeId){
                            this.appointments.push(response[i]) 
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


    public onDeleteAppointment(appointmentID?: string): void{
        
        this.appointmentService.deleteAppointment(appointmentID).subscribe(
            (response: void) => {

                //Reloading Appointment cards
                this.appointmentService.getAppointments().subscribe(
                    (response: Appointment[]) => {
                      this.appointments = [];
                      for (let i = 0; i < response.length; i++) {
                        if(response[i].employee.employeeId == environment.employeeId){
                            this.appointments.push(response[i]) 
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

    //Prescription//////////////////////////////////////////////////
    public displayPrescription(): void{
        this.hideAll();
        this.showPrescription = true;
    }   

    public onAddPrescription(addPrescriptionForm: NgForm): void{
        document.getElementById('add-prescription-form')?.click();
        this.prescriptionService.addPrescription(addPrescriptionForm.value).subscribe(
            (response: Prescription) => {

                //Reloading Prescription cards
                this.prescriptionService.getPrescriptions().subscribe(
                    (response: Prescription[]) => {
                      this.prescriptions = [];
                      for (let i = 0; i < response.length; i++) {
                        this.prescriptions.push(response[i]) 
                        addPrescriptionForm.reset();
                    }
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addPrescriptionForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public onEditPrescription(prescription: Prescription): void{
        
        let medicineId = String(prescription.medicineID);
        for(let i = 0; i < this.medicines.length; i++){
            if(medicineId == this.medicines[i].medicineID){
                prescription.medicineID = this.medicines[i];
            }
        }
        

        this.prescriptionService.updatePrescription(prescription).subscribe(
            (response: Prescription) => {

                //Reloading Prescription cards
                this.prescriptionService.getPrescriptions().subscribe(
                    (response: Prescription[]) => {
                      this.prescriptions = [];
                      for (let i = 0; i < response.length; i++) {
                        this.prescriptions.push(response[i]) 
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


    public onDeletePrescription(/*prescriptionId?*/scriptRef?: string): void{
        
        this.prescriptionService.deletePrescription(scriptRef).subscribe(
            (response: void) => {

                //Reloading Appointment cards
                this.prescriptionService.getPrescriptions().subscribe(
                    (response: Prescription[]) => {
                      this.prescriptions = [];
                      for (let i = 0; i < response.length; i++) {
                        this.prescriptions.push(response[i]) 
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

    
    public onOpenModalPrescription( mode: string, prescription?: Prescription): void {
        const container = document.getElementById('prescription-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addPrescriptionModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editPrescription = prescription;
        console.log(this.editAppointment);
        button.setAttribute('data-target', '#updatePrescriptionModal');
        }
        if (mode === 'delete') {
        this.deletePrescription = prescription;
        button.setAttribute('data-target', '#deleteModal');
        }
        container?.appendChild(button);
        button.click();
  }

    //Employees/////////////////////////////////////////////////////
    public displayEmployees(): void{
        this.hideAll();
        this.showEmployees = true;
    }  

    //Patients/////////////////////////////////////////////////////
    public displayPatients(): void{
        this.hideAll();
        this.showPatients = true;
    }  
    

    

}