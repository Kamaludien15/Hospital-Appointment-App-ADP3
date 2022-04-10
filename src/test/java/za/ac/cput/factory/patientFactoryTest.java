package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.patient;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class patientFactoryTest {
    public void patientFactoryTest(){
        patient patient = new patient.patientBuilder().setPatientID(Helper.generateID())
                                                      .setPatientFirstName(Helper.generateID())
                                                      .setPatientLastName(Helper.generateID())
                                                      .setPatientDateOfBirth(Helper.generateID())
                                                      .Builder();
        assertNotNull(patient);
    }

    @Test
    public void AppointmentFactoryTest(){

        patient patient = patientFactory.createPatient(Helper.generateID(), Helper.generateID(), Helper.generateID(), Helper.generateID());
        assertNotNull(patient);
    }
}