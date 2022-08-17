/* AppointmentFactory.java
 Factory for the Appointment Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class AppointmentFactory {

    public static Appointment createAppointment(Patient patient, Hospital hospital, Employee employee, Prescription prescription,
                                                Procedure procedure, String appointmentDate){

        //-----Checking for empty or null variables------
        if(Helper.checkingEntity(patient) || Helper.checkingEntity(hospital) || Helper.checkingEntity(employee) || Helper.checkingEntity(prescription)
                || Helper.checkingEntity(procedure) || Helper.isEmptyOrNull(appointmentDate))
            return null;

        //-----Generating AppointmentID-----
        String appointmentID = Helper.generateID();


        Appointment appointment = new Appointment.Builder()
                .setAppointmentID(appointmentID)
                .setPatient(patient)
                .setHospital(hospital)
                .setEmployee(employee)
                .setPrescription(prescription)
                .setProcedure(procedure)
                .setAppointmentDate(appointmentDate)
                .build();

        return appointment;
    }

}
