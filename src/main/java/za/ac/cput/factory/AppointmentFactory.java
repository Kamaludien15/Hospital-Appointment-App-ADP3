/* AppointmentFactory.java
 Factory for the Appointment Class
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import za.ac.cput.entity.Appointment;
import za.ac.cput.util.Helper;

public class AppointmentFactory {

    public static Appointment createAppointment(String patientID, String hospitalID, String employeeID, String scriptRef,
                                                String procedureID, String appointmentDate){

        //-----Checking for empty or null variables------
        if(Helper.isNullEmpty(patientID) || Helper.isNullEmpty(hospitalID) || Helper.isNullEmpty(employeeID) || Helper.isNullEmpty(scriptRef)
                || Helper.isNullEmpty(procedureID) || Helper.isNullEmpty(appointmentDate))
            return null;

        //-----Generating AppointmentID-----
        String appointmentID = Helper.generateID();


        Appointment appointment = new Appointment.Builder()
                .setAppointmentID(appointmentID)
                .setPatientID(patientID)
                .setHospitalID(hospitalID)
                .setEmployeeID(employeeID)
                .setScriptRef(scriptRef)
                .setProcedureID(procedureID)
                .setAppointmentDate(appointmentDate)
                .build();

        return appointment;
    }

}
