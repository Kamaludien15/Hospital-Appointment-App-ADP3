/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    Patient patient = PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999", "1234567890", "gg");
    Hospital hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    Employee employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997", "1234567890", "gg");
    Medicine medicine = MedicineFactory.createMedicine("Panado", "500ml", "Twice a day", "R500.00");
    Prescription prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
    Procedure procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", "R1000");

    //Testing Builder class for Appointment entity
    @Test
    public void AppointmentTest(){
        Appointment appointment = new Appointment.Builder()
                .setAppointmentID(Helper.generateID())
                .setPatient(patient)
                .setHospital(hospital)
                .setEmployee(employee)
                .setPrescription(prescription)
                .setProcedure(procedure)
                .setAppointmentDate("25-April-2022")
                .build();
        assertNotNull(appointment);
    }

    //Testing creation of Appointment entity with AppointmentFactory
    @Test
    public void AppointmentFactoryTest(){

        Appointment appointment = AppointmentFactory.createAppointment(patient, hospital, employee, prescription, procedure, "25-April-2022");
        assertNotNull(appointment);
    }

}