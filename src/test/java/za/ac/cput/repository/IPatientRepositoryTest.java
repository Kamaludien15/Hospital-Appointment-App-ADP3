/**
 * Rhegan Albert Fortuin
 * 219273693
 * PatientRepositoryTest
 * 16 August 2022
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.factory.PatientFactory;
import za.ac.cput.factory.PatientGenderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IPatientRepositoryTest {

    @Autowired private IPatientRepository patientRepository;
    private Patient patient;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");
    }

    @AfterEach
    void tearDown(){
        this.patientRepository.delete(this.patient);
    }

    @Test
    void save() {
        Patient saved = this.patientRepository.save(this.patient);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.patient, saved);
    }

    @Test
    void read() {
        Patient saved = this.patientRepository.save(this.patient);
        Optional<Patient> read = this.patientRepository.findById(this.patient.getPatientID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Patient saved = this.patientRepository.save(this.patient);
        this.patientRepository.delete(saved);
        List<Patient> patientListSet = this.patientRepository.findAll();
        assertEquals(0,patientListSet.size());
    }

    @Test
    void getAll() {
        this.patientRepository.save(this.patient);
        List<Patient> patientList = this.patientRepository.findAll();
        assertEquals(1,patientList.size());
    }
}