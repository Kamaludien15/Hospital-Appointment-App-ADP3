/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Appointment;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentFactoryTest {

    //Testing Builder class for Appointment entity
    @Test
    public void AppointmentTest(){
        Appointment appointment = new Appointment.Builder()
                .setAppointmentID(Helper.generateID())
                .setPatientID(Helper.generateID())
                .setHospitalID(Helper.generateID())
                .setEmployeeID(Helper.generateID())
                .setScriptRef(Helper.generateID())
                .setProcedureID(Helper.generateID())
                .setAppointmentDate("25-April-2022")
                .build();
        assertNotNull(appointment);
    }

    //Testing creation of Appointment entity with AppointmentFactory
    @Test
    public void AppointmentFactoryTest(){

        Appointment appointment = AppointmentFactory.createAppointment(Helper.generateID(), Helper.generateID(), Helper.generateID(),
                                                                Helper.generateID(), Helper.generateID(), "25-April-2022");
        assertNotNull(appointment);
    }

}