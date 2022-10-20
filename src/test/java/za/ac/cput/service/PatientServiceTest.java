/**
 * PatientServiceTest.java
 * Test Class for PatientService
 * Rhegan Albert Fortuin
 * 2022/10/13
 */
package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.factory.PatientFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientServiceTest {
    private Patient patientService;

    @Autowired
    private PatientService service;

    @BeforeEach
    void setUp() {
        this.patientService = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000", "password");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(patientService);
    }

    @Test
    void save() {
        Patient saved = this.service.save(this.patientService);
        assertNotNull(saved);
        assertSame(this.patientService.getPatientID(), saved.getPatientID());
    }

    @Test
    void read() {
        Patient saved = this.service.save(this.patientService);
        Optional<Patient> read = this.service.read(this.patientService.getPatientID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getPatientID(), read.get().getPatientID())
        );
    }

    @Test
    void delete() {
        Patient saved = this.service.save(this.patientService);
        this.service.delete(saved);
        List<Patient> patientList = this.service.getAll();
        assertEquals(0,patientList.size());
    }

    @Test
    void getAll() {
        this.service.save(this.patientService);
        List<Patient> patientList = this.service.getAll();
        assertEquals(1,patientList.size());
    }
}