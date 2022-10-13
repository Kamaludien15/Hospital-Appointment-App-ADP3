package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Patient;
import za.ac.cput.factory.PatientFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IPatientRepositoryTest {
    @Autowired
    private IPatientRepository patientRepository;

    private Patient patient;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");

    }

    @AfterEach
    void tearDown() {
        this.patientRepository.delete(this.patient);
    }

    @Test
    void save() {
        Patient saved = this.patientRepository.save(this.patient);
        assertNotNull(saved);
        assertSame(this.patient.getPatientID(), saved.getPatientID());
    }


    @Test
    void read() {
        Patient saved = this.patientRepository.save(this.patient);
        Optional<Patient> read = this.patientRepository.findById(this.patient.getPatientID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getPatientID(), read.get().getPatientID())
        );
    }

    @Test
    void delete() {
        Patient saved = this.patientRepository.save(this.patient);
        this.patientRepository.delete(saved);
        List<Patient> patientList = this.patientRepository.findAll();
        assertEquals(0,patientList.size());
    }

    @Test
    void getAll() {
        this.patientRepository.save(this.patient);
        List<Patient> patientList = this.patientRepository.findAll();
        assertEquals(1,patientList.size());
    }
}