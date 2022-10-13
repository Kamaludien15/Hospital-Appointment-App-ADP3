package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.factory.PatientFactory;
import za.ac.cput.factory.PatientGenderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IPatientGenderRepositoryTest {
    @Autowired
    private IGenderRepository genderRepository;
    @Autowired
    private IPatientRepository patientRepository;
    @Autowired
    private IPatientGenderRepository patientGenderRepository;

    private Gender gender;
    private Patient patient;
    private PatientGender patientGender;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
        this.patient = PatientFactory.createPatient("Rhegan", "Fortuin", "19 August 2000");
        this.patientGender = PatientGenderFactory.createPatientGender(patient, gender);
    }

    @AfterEach
    void tearDown() {
        this.genderRepository.delete(this.gender);
        this.patientRepository.delete(this.patient);
        this.patientGenderRepository.delete(this.patientGender);
    }

    @Test
    void save() {
        Gender savedGender = this.genderRepository.save(this.gender);
        Patient savedPatient = this.patientRepository.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderRepository.save(this.patientGender);

        assertNotNull(savedPatientGender);
        assertSame(this.patientGender.getPatientGenderID(), savedPatientGender.getPatientGenderID());
    }


    @Test
    void read() {
        Gender savedGender = this.genderRepository.save(this.gender);
        Patient savedPatient = this.patientRepository.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderRepository.save(this.patientGender);

        Optional<PatientGender> read = this.patientGenderRepository.findById(this.patientGender.getPatientGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(savedPatientGender.getPatientGenderID(), read.get().getPatientGenderID())
        );
    }

    @Test
    void delete() {
        Gender savedGender = this.genderRepository.save(this.gender);
        Patient savedPatient = this.patientRepository.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderRepository.save(this.patientGender);
        this.patientGenderRepository.delete(savedPatientGender);
        List<PatientGender> patientGender = this.patientGenderRepository.findAll();
        assertEquals(0,patientGender.size());
    }

    @Test
    void getAll() {
        Gender savedGender = this.genderRepository.save(this.gender);
        Patient savedPatient = this.patientRepository.save(this.patient);
        PatientGender savedPatientGender = this.patientGenderRepository.save(this.patientGender);
        List<PatientGender> patientGender = this.patientGenderRepository.findAll();
        assertEquals(1,patientGender.size());
    }
}