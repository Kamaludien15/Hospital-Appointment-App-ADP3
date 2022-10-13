package za.ac.cput.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientAPITest {
    @Autowired private PatientAPI patientAPI;
    private Patient patient;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");
    }

    @AfterEach
    void tearDown(){
        this.patientAPI.delete(this.patient);
    }

    @Test
    void save() {
        Patient savedPatient = this.patientAPI.save(this.patient);
        assertNotNull(savedPatient);

        assertSame(this.patient.getPatientID(), savedPatient.getPatientID());
    }

    @Test
    void read() {
        Patient savedPatient = this.patientAPI.save(this.patient);

        Optional<Patient> read = this.patientAPI.read(this.patient.getPatientID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(savedPatient.getPatientID(), read.get().getPatientID())
        );
    }

    @Test
    void delete() {
        Patient savedPatient = this.patientAPI.save(this.patient);

        this.patientAPI.delete(savedPatient);
        List<Patient> patientListSet = this.patientAPI.getAll();
        assertEquals(0,patientListSet.size());
    }

    @Test
    void getAll() {
        Patient savedPatient = this.patientAPI.save(this.patient);

        List<Patient> patientList = this.patientAPI.getAll();
        assertEquals(1,patientList.size());
    }
}