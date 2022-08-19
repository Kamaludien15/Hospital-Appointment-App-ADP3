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

class PatientFactoryTest {
    @Test
    public void patientFactoryTest(){
        Patient patient = new Patient.patientBuilder().setPatientID(Helper.generateID())
                                                      .setPatientFirstName("Rhegan")
                                                      .setPatientLastName("Fortuin")
                                                      .setPatientDateOfBirth("19 August 2000")
                                                      .build();
        assertNotNull(patient);
    }
}