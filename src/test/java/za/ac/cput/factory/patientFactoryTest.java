/**
 * Rhegan Albert Fortuin
 * 219273693
 * PatientFactoryTest
 * 15 August 2022
 */

package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Patient;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
class PatientFactoryTest {
    @Test
    public void patientFactoryTest(){
        Patient patient = new Patient.patientBuilder().setPatientID(Helper.generateID())
                                                      .setPatientFirstName("Rhegan")
                                                      .setPatientLastName("Fortuin")
                                                      .setPatientDateOfBirth("19 August 2000")
                                                      .build();
=======
class patientFactoryTest {
    public void patientFactoryTest(){
        Patient patient = new Patient.patientBuilder().setPatientID(Helper.generateID())
                                                      .setPatientFirstName(Helper.generateID())
                                                      .setPatientLastName(Helper.generateID())
                                                      .setPatientDateOfBirth(Helper.generateID())
                                                      .Builder();
        assertNotNull(patient);
    }

    @Test
    public void AppointmentFactoryTest(){

        Patient patient = PatientFactory.createPatient(Helper.generateID(), Helper.generateID(), Helper.generateID(), Helper.generateID());
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
        assertNotNull(patient);
    }
}