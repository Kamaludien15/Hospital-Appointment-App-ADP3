/**
 * Rhegan Albert Fortuin
 * 219273693
 * PatientGenderRepositoryTest
 * 16 August 2022
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.factory.PatientFactory;
import za.ac.cput.factory.PatientGenderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IPatientGenderRepositoryTest {

    @Autowired private IPatientGenderRepository patientGenderRepository;
    private Patient patient;
    private Gender gender;
    private PatientGender patientGender;

    @BeforeEach
    void setUp() {
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
        this.patientGender = PatientGenderFactory.createPatientGender(patient, gender);
    }

    @AfterEach
    void tearDown(){
        this.patientGenderRepository.delete(this.patientGender);
    }

    @Test
    void save() {
        PatientGender saved = this.patientGenderRepository.save(this.patientGender);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.patientGender, saved);
    }

    @Test
    void read() {
        PatientGender saved = this.patientGenderRepository.save(this.patientGender);
        Optional<PatientGender> read = this.patientGenderRepository.findById(this.patientGender.getPatientGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        PatientGender saved = this.patientGenderRepository.save(this.patientGender);
        this.patientGenderRepository.delete(saved);
        List<PatientGender> patientGenderListSet = this.patientGenderRepository.findAll();
        assertEquals(0,patientGenderListSet.size());
    }

    @Test
    void getAll() {
        this.patientGenderRepository.save(this.patientGender);
        List<PatientGender> patientGenderList = this.patientGenderRepository.findAll();
        assertEquals(1,patientGenderList.size());
    }
}