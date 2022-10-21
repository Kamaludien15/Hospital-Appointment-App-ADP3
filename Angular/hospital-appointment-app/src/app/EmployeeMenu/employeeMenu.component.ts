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
import { LocationService } from '../Service/location.service';
import { Location } from '../Domain/location';
import { PrescriptionService } from '../Service/prescription.service';
import { Prescription } from '../Domain/prescription';
import { Procedure } from '../Domain/procedure';
import { ProcedureService } from '../Service/procedure.service';
import {v4 as uuids4} from 'uuid';

@Component({ templateUrl: 'employeeMenu.component.html' })
export class EmployeeMenuComponent implements OnInit{

    constructor(private procedureService: ProcedureService,private prescriptionService: PrescriptionService,private hospitalService: HospitalService,private locationService: LocationService,private appointmentService: AppointmentService, private employeeService: EmployeeService, private patientService: PatientService) { }

    public appointments: Appointment[] = [];
    public employees: Employee[] = [];
    public patients: Patient[] = [];
    public hospitals: Hospital[] = [];
    public locations: Location[] = [];
    public prescriptions: Prescription[] = [];
    public procedures: Procedure[] = [];
    public generatedId: String | undefined;
    public editAppointment: Appointment | undefined;
    public deleteAppointment: Appointment | undefined;
    public editHospital: Hospital | undefined;
    public deleteHospital: Hospital | undefined;
    public editLocation: Location | undefined;
    public deleteLocation: Location | undefined;

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
    public showHospital = false;
    public showLocation = false;

    //Hide All
    public hideAll(): void{
        this.showAppointment = false;
        this.showPatients = false;
        this.showEmployees = false;
        this.showHospital = false;
        this.showLocation = false;
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
    
    //Hospital//////////////////////////////////////////////////
    public displayHospital(): void{
        this.hideAll();
        this.showHospital = true;
    }   

    public onAddHospital(addHospitalForm: NgForm): void{
        document.getElementById('add-hospital-form')?.click();
        this.hospitalService.addHospital(addHospitalForm.value).subscribe(
            (response: Hospital) => {

                //Reloading Hospital cards
                this.hospitalService.getHospitals().subscribe(
                    (response: Hospital[]) => {
                      this.hospitals = [];
                        for (let i = 0; i < response.length; i++) {
                            this.hospitals.push(response[i]) 
                            addHospitalForm.reset();
                        }
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addHospitalForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public onEditHospital(hospital: Hospital): void{
        this.hospitalService.updateHospital(hospital).subscribe(
            (response: Hospital) => {

                //Reloading Hospital cards
                this.hospitalService.getHospitals().subscribe(
                    (response: Hospital[]) => {
                      this.hospitals = [];
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


    public onDeleteHospital(hospitalId?: string): void{
        
        this.hospitalService.deleteHospital(hospitalId!).subscribe(
            (response: void) => {

                //Reloading Hospital cards
                this.hospitalService.getHospitals().subscribe(
                    (response: Hospital[]) => {
                      this.hospitals = [];
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

    
    public onOpenModalHospital( mode: string, hospital?: Hospital): void {
        const container = document.getElementById('hospital-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addHospitalModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editHospital = hospital;
        console.log(this.editHospital);
        button.setAttribute('data-target', '#updateHospitalModal');
        }
        if (mode === 'delete') {
        this.deleteHospital = hospital;
        button.setAttribute('data-target', '#deleteHospitalModal');
        }
        container?.appendChild(button);
        button.click();
    }   
    //Location//////////////////////////////////////////////////
    public displayLocation(): void{
        this.hideAll();
        this.showLocation = true;
    }   

    public onAddLocation(addLocationForm: NgForm): void{
        document.getElementById('add-location-form')?.click();
        this.locationService.addLocation(addLocationForm.value).subscribe(
            (response: Location) => {

                //Reloading Location cards
                this.locationService.getLocations().subscribe(
                    (response: Location[]) => {
                      this.locations = [];
                        for (let i = 0; i < response.length; i++) {
                            this.locations.push(response[i]) 
                            addLocationForm.reset();
                        }
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addLocationForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public onEditLocation(location: Location): void{
        this.locationService.updateLocation(location).subscribe(
            (response: Location) => {

                //Reloading Location cards
                this.locationService.getLocations().subscribe(
                    (response: Location[]) => {
                      this.locations = [];
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


    public onDeleteLocation(locationId?: string): void{
        
        this.locationService.deleteLocation(locationId!).subscribe(
            (response: void) => {

                //Reloading Location cards
                this.locationService.getLocations().subscribe(
                    (response: Location[]) => {
                      this.locations = [];
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

    
    public onOpenModalLocation( mode: string, location?: Location): void {
        const container = document.getElementById('location-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addLocationModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editLocation = location;
        console.log(this.editLocation);
        button.setAttribute('data-target', '#updateLocationModal');
        }
        if (mode === 'delete') {
        this.deleteLocation = location;
        button.setAttribute('data-target', '#deleteLocationModal');
        }
        container?.appendChild(button);
        button.click();
    }   
}