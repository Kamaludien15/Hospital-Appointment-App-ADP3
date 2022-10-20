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
class PatientGenderAPITest {
    @Autowired private PatientAPI patientAPI;
    @Autowired private GenderAPI genderAPI;
    @Autowired private PatientGenderAPI patientGenderAPI;
    private Patient patient;
    private Gender gender;
    private PatientGender patientGender;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000", "password");
        this.patientGender = PatientGenderFactory.createPatientGender(patient, gender);
    }

    @AfterEach
    void tearDown(){
        this.patientAPI.delete(this.patient);
        this.genderAPI.delete(this.gender);
        this.patientGenderAPI.delete(this.patientGender);
    }

    @Test
    void save() {
        Gender savedGender = this.genderAPI.save(this.gender);
        Patient savedPatient = this.patientAPI.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderAPI.save(this.patientGender);
        assertNotNull(savedPatientGender);

        assertSame(this.patientGender.getPatientGenderID(), savedPatientGender.getPatientGenderID());
    }

    @Test
    void read() {
        Gender savedGender = this.genderAPI.save(this.gender);
        Patient savedPatient = this.patientAPI.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderAPI.save(this.patientGender);

        Optional<PatientGender> read = this.patientGenderAPI.read(this.patientGender.getPatientGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(savedPatientGender.getPatientGenderID(), read.get().getPatientGenderID())
        );
    }

    @Test
    void delete() {
        Gender savedGender = this.genderAPI.save(this.gender);
        Patient savedPatient = this.patientAPI.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderAPI.save(this.patientGender);

        this.patientGenderAPI.delete(savedPatientGender);
        List<PatientGender> patientGenderListSet = this.patientGenderAPI.getAll();
        assertEquals(0,patientGenderListSet.size());
    }

    @Test
    void getAll() {
        Gender savedGender = this.genderAPI.save(this.gender);
        Patient savedPatient = this.patientAPI.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderAPI.save(this.patientGender);

        List<PatientGender> patientGenderList = this.patientGenderAPI.getAll();
        assertEquals(1,patientGenderList.size());
    }
}