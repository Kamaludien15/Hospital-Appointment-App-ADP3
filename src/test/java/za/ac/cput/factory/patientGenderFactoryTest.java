package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

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
        assertNotNull(patientGender);
    }
}