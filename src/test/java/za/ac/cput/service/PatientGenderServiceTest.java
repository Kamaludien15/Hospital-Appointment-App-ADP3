/**
 * PatientGenderServiceTest.java
 * Test Class for PatientGenderService
 * Rhegan Albert Fortuin
 * 2022/10/13
 */
package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.util.Helper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PatientGenderServiceTest {

    private Gender gender;
    private Patient patient;
    private PatientGender patientGender;

    @Autowired private GenderService genderService;
    @Autowired private PatientService patientService;
    @Autowired private PatientGenderService patientGenderService;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");
        this.patientGender = PatientGenderFactory.createPatientGender(patient, gender);

    }

    @AfterEach
    void tearDown() {
        this.genderService.delete(gender);
        this.patientService.delete(patient);
        this.patientGenderService.delete(patientGender);
    }

    @Test
    void save() {
        Gender savedGender = this.genderService.save(this.gender);
        Patient savedPatient = this.patientService.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderService.save(this.patientGender);
        assertNotNull(savedPatientGender);
        assertSame(this.patientGender.getPatientGenderID(), savedPatientGender.getPatientGenderID());
    }

    @Test
    void read() {
        Gender savedGender = this.genderService.save(this.gender);
        Patient savedPatient = this.patientService.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderService.save(this.patientGender);
        Optional<PatientGender> read = this.patientGenderService.read(patientGender.getPatientGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(savedPatientGender.getPatientGenderID(), read.get().getPatientGenderID())
        );
    }

    @Test
    void delete() {
        Gender savedGender = this.genderService.save(this.gender);
        Patient savedPatient = this.patientService.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderService.save(this.patientGender);
        this.patientGenderService.delete(savedPatientGender);
        List<PatientGender> patientGenderList = this.patientGenderService.getAll();
        assertEquals(0,patientGenderList.size());
    }

    @Test
    void getAll() {
        Gender savedGender = this.genderService.save(this.gender);
        Patient savedPatient = this.patientService.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderService.save(this.patientGender);
        List<PatientGender> patientGenderList = this.patientGenderService.getAll();
        assertEquals(1,patientGenderList.size());
    }
}