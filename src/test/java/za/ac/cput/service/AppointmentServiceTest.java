/* AddressServicesImplTest.java
 Test class for AddressServices
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.AppointmentService;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AppointmentServiceTest {

    private Appointment appointment;
    private Patient patient;
    private Hospital hospital;
    private Employee employee;
    private Medicine medicine;
    private Prescription prescription;
    private Procedure procedure;

    @Autowired private AppointmentService service;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rick", "Rock", "01-Janurary-1999");
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
        this.employee = EmployeeFactory.createEmployee("James", "Johnson", "01-Janurary-1997");
        this.medicine = MedicineFactory.createMedicine("Panado", "500ml", "Twice a day", "R500.00");
        this.prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
        this.procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", "R1000");
        this.appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(appointment);
    }

    @Test
    void save() {
        Appointment saved = this.service.save(this.appointment);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.appointment, saved);
    }

    @Test
    void read() {
        Appointment saved = this.service.save(this.appointment);
        Optional<Appointment> read = this.service.read(appointment.getAppointmentID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Appointment saved = this.service.save(this.appointment);
        this.service.delete(saved);
        List<Appointment> addressSet = this.service.getAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.service.save(this.appointment);
        List<Appointment> addressSet = this.service.getAll();
        assertEquals(1,addressSet.size());
    }
}