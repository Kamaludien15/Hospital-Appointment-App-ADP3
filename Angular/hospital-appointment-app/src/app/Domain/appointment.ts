import { Employee } from './employee';
import { Hospital } from './hospital';
import { Patient } from './patient';
import { Prescription } from './prescription';
import { Procedure } from './procedure';

export interface Appointment {
    appointmentID: string;
    patient: Patient;
    hospital: Hospital;
    employee: Employee;
    prescription: Prescription;
    procedure: Procedure;
    appointmentDate: string;
}