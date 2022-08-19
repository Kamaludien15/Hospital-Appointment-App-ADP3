/**
 * Rhegan Albert Fortuin
 * 219273693
 * GenderServiceTest
 * 16 August 2022
 */

package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Patient;
import za.ac.cput.factory.PatientFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {
    
    @Autowired
    private IPatientService patientService;
    private Patient patient;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");
    }

    @AfterEach
    void tearDown(){
        this.patientService.delete(this.patient);
    }

    @Test
    void save() {
        Patient saved = this.patientService.save(this.patient);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.patient, saved);
    }

    @Test
    void read() {
        Patient saved = this.patientService.save(this.patient);
        Optional<Patient> read = this.patientService.read(this.patient.getPatientID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Patient saved = this.patientService.save(this.patient);
        this.patientService.delete(saved);
        List<Patient> patientListSet = this.patientService.getAll();
        assertEquals(0,patientListSet.size());
    }

    @Test
    void getAll() {
        this.patientService.save(this.patient);
        List<Patient> patientList = this.patientService.getAll();
        assertEquals(1,patientList.size());
    }
}