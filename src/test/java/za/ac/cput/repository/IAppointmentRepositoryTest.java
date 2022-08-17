/* AppointmentFactoryTest.java
 Testing class for AppointmentFactoryTest
 Author: Dominic Dave Przygonski (219206414)
 Date: 09 April 2022
*/
package za.ac.cput.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;


import java.util.List;
import java.util.Optional;

@SpringBootTest
class IAppointmentRepositoryTest {

    @Autowired private IAppointmentRepository appointmentRepository;
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
       this.medicine = MedicineFactory.createMedicine("500ml", "Twice Day", 500);
       this.prescription = PrescriptionFactory.createPrescription(medicine, "01-Janurary-2022", "Twice a year");
       this.procedure = ProcedureFactory.createProcedure("Eye Sight Test", "Test patients eyesight strength", 1000);
       this.appointment = AppointmentFactory.createAppointment(patient,hospital,employee,prescription,procedure,"01-January-2022");
    }

    @AfterEach
    void tearDown(){
        this.appointmentRepository.delete(this.appointment);
    }

    @Test
    void save() {
        Appointment saved = this.appointmentRepository.save(this.appointment);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.appointment, saved);
    }

    @Test
    void read() {
        Appointment saved = this.appointmentRepository.save(this.appointment);
        Optional<Appointment> read = this.appointmentRepository.findById(this.appointment.getAppointmentID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Appointment saved = this.appointmentRepository.save(this.appointment);
        this.appointmentRepository.delete(saved);
        List<Appointment> appointmentListSet = this.appointmentRepository.findAll();
        assertEquals(0,appointmentListSet.size());
    }

    @Test
    void getAll() {
        this.appointmentRepository.save(this.appointment);
        List<Appointment> appointmentList = this.appointmentRepository.findAll();
        assertEquals(1,appointmentList.size());
    }
}