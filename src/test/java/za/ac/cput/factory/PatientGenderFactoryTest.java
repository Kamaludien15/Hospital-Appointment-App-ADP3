package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.*;

import static org.junit.jupiter.api.Assertions.*;
class PatientGenderFactoryTest {
    Patient patient = PatientFactory.createPatient("Rheagn", "Fortuin", "19 August 2000", "1234567890", "gg");
    Gender gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");

    @Test
    public void patientFactoryTest(){
        PatientGender patientGender = new PatientGender.patientGenderBuilder()
                                                       .setPatientGenderID(Helper.generateID())
                                                       .setPatientID(patient)
                                                       .setGenderID(gender)
                                                       .build();
        assertNotNull(patientGender);
    }
}