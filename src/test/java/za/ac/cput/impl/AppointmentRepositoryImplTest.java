/* AppointmentRepositoryImplTest.java
 Testing class for AppointmentRepositoryImpl
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/

package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Appointment;
import za.ac.cput.factory.AppointmentFactory;
import za.ac.cput.repository.impl.AppointmentRepositoryImpl;
import za.ac.cput.util.Helper;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class AppointmentRepositoryImplTest {

    private static AppointmentRepositoryImpl repository = AppointmentRepositoryImpl.getRepository();
    private static Appointment appointment = AppointmentFactory.createAppointment(Helper.generateID(), Helper.generateID(), Helper.generateID(),
            Helper.generateID(), Helper.generateID(), "03-December-2022");

    @Test
    void a_create() {
        Appointment created = repository.create(appointment);
        assertEquals(appointment.getAppointmentID(), created.getAppointmentID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Appointment read = repository.read(appointment.getAppointmentID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Appointment update = new Appointment.Builder()
                .copy(appointment)
                .setAppointmentDate("09-June-2023")
                .build();
        Appointment updatedApp = repository.update(update);
        assertNotNull(updatedApp);
        System.out.println("Updated: " + updatedApp.getAppointmentDate());

    }

    @Test
    void d_getAll() {
        System.out.println("Show All: ");
        System.out.println(repository.getAll());
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(appointment.getAppointmentID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }


}