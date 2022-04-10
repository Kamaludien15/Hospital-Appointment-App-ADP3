package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.patientGender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class patientGenderFactoryTest {
    public void patientFactoryTest(){
        patientGender patientGender = new patientGender.patientGenderBuilder().setPatientID(Helper.generateID())
                                                                        .setGenderID(Helper.generateID())
                                                                        .Builder();
        assertNotNull(patientGender);
    }

    @Test
    public void AppointmentFactoryTest(){

        patientGender patientGender = patientGenderFactory.createPatientGender(Helper.generateID(), Helper.generateID());
        assertNotNull(patientGender);
    }
}