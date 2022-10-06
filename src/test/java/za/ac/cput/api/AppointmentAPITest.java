/* AddressAPITest.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.IAppointmentService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class AppointmentAPITest {

    @Autowired private AppointmentAPI api;
    @Autowired private IAppointmentService appointmentService;
    private Patient patient;
    private Hospital hospital;
    private Employee employee;
    private Medicine medicine;
    private Prescription prescription;
    private Procedure procedure;
    private Appointment appointment;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999");
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997");
        this.medicine = MedicineFactory.createMedicine("Panado", "500ml", "Twice a day", "R500.00");
        this.prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
        this.procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", "R1000.00");
        this.appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");
    }

    @Test
    void save() {
        Appointment saved = this.api.save(this.appointment);
    }

    @Test
    void read() {
        Optional<Appointment> saved = this.api.read(this.appointment.getAppointmentID());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.appointment);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Optional<Appointment> saved = this.api.read(this.appointment.getAppointmentID());
        assertEquals(1, this.api.getAll().size());
    }
}