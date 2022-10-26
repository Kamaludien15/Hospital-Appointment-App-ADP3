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
import {v4 as uuids4} from 'uuid';
import { Medicine } from '../Domain/medicine';
import { MedicineService } from '../Service/medicine.service';
import { Location } from '../Domain/location';
import { LocationService } from '../Service/location.service';

@Component({ templateUrl: 'employeeMenu.component.html' })
export class EmployeeMenuComponent implements OnInit{

    constructor(private procedureService: ProcedureService,private prescriptionService: PrescriptionService,private hospitalService: HospitalService,private appointmentService: AppointmentService, private employeeService: EmployeeService, private patientService: PatientService, private medicineService: MedicineService,private locationService: LocationService) { }

    public appointments: Appointment[] = [];
    public employees: Employee[] = [];
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
    public showMedicines = false;
    public showProcedures = false;
    public showHospital = false;
    public showLocation = false;
    public showPrescriptions = false;

    //Hide All
    public hideAll(): void{
        this.showAppointment = false;
        this.showPatients = false;
        this.showEmployees = false;
        this.showMedicines = false;
        this.showProcedures = false;
        this.showHospital = false;
        this.showLocation = false;
        this.showPrescriptions = false;
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

    public onAddEmployee(addEmployeeForm: NgForm): void{
        document.getElementById('add-employee-form')?.click();
        this.employeeService.addEmployee(addEmployeeForm.value).subscribe(
            (response: Employee) => {

                //Reloading Employee cards
                this.employeeService.getEmployees().subscribe(
                    (response: Employee[]) => {
                      this.employees = response;
                      addEmployeeForm.reset();
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addEmployeeForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public onEditEmployee(employee: Employee): void{
        
        this.employeeService.updateEmployee(employee).subscribe(
            (response: Employee) => {

                //Reloading Employee cards
                this.employeeService.getEmployees().subscribe(
                    (response: Employee[]) => {
                      this.employees = response;    
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


    public onDeleteEmployee(employeeID?: string): void{
        
        this.employeeService.deleteEmployee(employeeID).subscribe(
            (response: void) => {

                //Reloading Employee cards
                this.employeeService.getEmployees().subscribe(
                    (response: Employee[]) => {
                      this.employees = response;
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

    
    public onOpenModalEmployee( mode: string, employee?: Employee): void {
        const container = document.getElementById('employee-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {
        button.setAttribute('data-target', '#addEmployeeModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editEmployee = employee;
        console.log(this.editEmployee);
        button.setAttribute('data-target', '#updateEmployeeModal');
        }
        if (mode === 'delete') {
        this.deleteEmployee = employee;
        button.setAttribute('data-target', '#deleteEmployeeModal');
        }
        container?.appendChild(button);
        button.click();
    }


    //Patients/////////////////////////////////////////////////////
    public displayPatients(): void{
        this.hideAll();
        this.showPatients = true;
    }

    public onAddPatient(addPatientForm: NgForm): void{
        document.getElementById('add-patient-form')?.click();
        this.patientService.addPatient(addPatientForm.value).subscribe(
            (response: Patient) => {

                //Reloading Patient cards
                this.patientService.getPatients().subscribe(
                    (response: Patient[]) => {
                      this.patients = response;
                      addPatientForm.reset();
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addPatientForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }

    public onEditPatient(patient: Patient): void{
        
        this.patientService.updatePatient(patient).subscribe(
            (response: Patient) => {

                //Reloading Patient cards
                this.patientService.getPatients().subscribe(
                    (response: Patient[]) => {
                      this.patients = response;    
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


    public onDeletePatient(patientID?: string): void{
        
        this.patientService.deletePatient(patientID).subscribe(
            (response: void) => {

                //Reloading Patient cards
                this.patientService.getPatients().subscribe(
                    (response: Patient[]) => {
                      this.patients = response;
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
        if (mode === 'add') {
        button.setAttribute('data-target', '#addPatientModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editPatient = patient;
        console.log(this.editPatient);
        button.setAttribute('data-target', '#updatePatientModal');
        }
        if (mode === 'delete') {
        this.deletePatient = patient;
        button.setAttribute('data-target', '#deletePatientModal');
        }
        container?.appendChild(button);
        button.click();
    }
    


    //Procedure/////////////////////////////////////////////////////
    public displayProcedures(): void{
        this.hideAll();
        this.showProcedures = true;
    }

    public onAddProcedure(addProcedureForm: NgForm): void{
        document.getElementById('add-procedure-form')?.click();
        this.procedureService.addProcedure(addProcedureForm.value).subscribe(
            (response: Procedure) => {

                //Reloading Procedure cards
                this.procedureService.getProcedures().subscribe(
                    (response: Procedure[]) => {
                      this.procedures = [];
                      for (let i = 0; i < response.length; i++) {
                        this.procedures.push(response[i]) 
                        addProcedureForm.reset();
                    }
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addProcedureForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }


    public onEditProcedure(procedure: Procedure): void{
        
        this.procedureService.updateProcedure(procedure).subscribe(
            (response: Procedure) => {

                //Reloading Procedure cards
                this.procedureService.getProcedures().subscribe(
                    (response: Procedure[]) => {
                      this.procedures = [];
                      for (let i = 0; i < response.length; i++) {
                        this.procedures.push(response[i]) 
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

    public onDeleteProcedure(procedureID?: string): void{

        this.procedureService.deleteProcedure(procedureID).subscribe(
            (response: void) => {
                
                //Reloading Procedure cards
                this.procedureService.getProcedures().subscribe(
                    (response: Procedure[]) => {
                      this.procedures = [];
                      for (let i = 0; i < response.length; i++) {
                        this.procedures.push(response[i]) 
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

    public onAddMedicine(addMedicineForm: NgForm): void{
        document.getElementById('add-medicine-form')?.click();
        this.medicineService.addMedicine(addMedicineForm.value).subscribe(
            (response: Medicine) => {

                //Reloading Medicine cards
                this.medicineService.getMedicine().subscribe(
                    (response: Medicine[]) => {
                      this.medicines = [];
                      for (let i = 0; i < response.length; i++) {
                        this.medicines.push(response[i]) 
                        addMedicineForm.reset();
                    }
                    },
                    (error: HttpErrorResponse) => {
                      alert(error.message);
                      addMedicineForm.reset();
                    })
            },
            (error: HttpErrorResponse) => {
                alert(error.message)
            }
        );
    }


    public onEditMedicine(medicine: Medicine): void{
        
        this.medicineService.updateMedicine(medicine).subscribe(
            (response: Medicine) => {

                //Reloading Medicine cards
                this.medicineService.getMedicine().subscribe(
                    (response: Medicine[]) => {
                      this.medicines = [];
                      for (let i = 0; i < response.length; i++) {
                        this.medicines.push(response[i]) 
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

    public onDeleteMedicine(medicineID?: string): void{

        this.medicineService.deleteMedicine(medicineID).subscribe(
            (response: void) => {
                
                //Reloading Medicine cards
                this.medicineService.getMedicine().subscribe(
                    (response: Medicine[]) => {
                      this.medicines = [];
                      for (let i = 0; i < response.length; i++) {
                        this.medicines.push(response[i]) 
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
                        for (let i = 0; i < response.length; i++) {
                          this.hospitals.push(response[i]) 
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


    public onDeleteHospital(hospitalID?: string): void{
        
        this.hospitalService.deleteHospital(hospitalID).subscribe(
            (response: void) => {

                //Reloading Hospital cards
                this.hospitalService.getHospitals().subscribe(
                    (response: Hospital[]) => {
                        this.hospitals = [];
                        for (let i = 0; i < response.length; i++) {
                          this.hospitals.push(response[i]) 
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
                        for (let i = 0; i < response.length; i++) {
                          this.locations.push(response[i]) 
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


    public onDeleteLocation(locationId?: string): void{
        
        this.locationService.deleteLocation(locationId).subscribe(
            (response: void) => {

                //Reloading Location cards
                this.locationService.getLocations().subscribe(
                    (response: Location[]) => {
                      this.locations = [];
                      for (let i = 0; i < response.length; i++) {
                        this.locations.push(response[i]) 
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

//Prescription//////////////////////////////////////////////////
public displayPrescription(): void{
    this.hideAll();
    this.showPrescriptions = true;
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
                    this.prescriptions.push(response[i]); 
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


public onDeletePrescription(scriptRef?: string): void{
    
    this.prescriptionService.deletePrescription(scriptRef).subscribe(
        (response: void) => {

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
    public onOpenModalPrescription( mode: string, prescription?: Prescription): void {
        const container = document.getElementById('prescription-Container');
        const button = document.createElement('button');
        button.type = 'button';
        button.style.display = 'none';
        button.setAttribute('data-toggle', 'modal');
        if (mode === 'add') {button.setAttribute('data-target', '#addPrescriptionModal');
        this.generateId();
        }
        if (mode === 'edit') {
        this.editPrescription = prescription;
        console.log(this.editPrescription);
        button.setAttribute('data-target', '#updatePrescriptionModal');
        }
        if (mode === 'delete') {
        this.deletePrescription = prescription;
        button.setAttribute('data-target', '#deletePrescriptionModal');
        }
        container?.appendChild(button);
        button.click();
    }
}