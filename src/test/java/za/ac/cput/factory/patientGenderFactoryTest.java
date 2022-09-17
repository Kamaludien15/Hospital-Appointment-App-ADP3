/**
 * Rhegan Albert Fortuin
 * 219273693
 * PatientGenderFactoryTest
 * 15 August 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
<<<<<<< HEAD
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
class PatientGenderFactoryTest {
    Patient patient = PatientFactory.createPatient("Rheagn", "Fortuin", "19 August 2000");
    Gender gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");

    @Test
    public void patientFactoryTest(){
        PatientGender patientGender = new PatientGender.patientGenderBuilder()
                                                       .setPatientGenderID(Helper.generateID())
                                                       .setPatientID(patient)
                                                       .setGenderID(gender)
                                                       .build();
=======
class patientGenderFactoryTest {
    public void patientFactoryTest(){
        PatientGender patientGender = new PatientGender.patientGenderBuilder().setPatientID(Helper.generateID())
                                                                        .setGenderID(Helper.generateID())
                                                                        .Builder();
        assertNotNull(patientGender);
    }

    @Test
    public void AppointmentFactoryTest(){

        PatientGender patientGender = PatientGenderFactory.createPatientGender(Helper.generateID(), Helper.generateID());
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
        assertNotNull(patientGender);
    }
}