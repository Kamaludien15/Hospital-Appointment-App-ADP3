package za.ac.cput.factory;

import za.ac.cput.domain.Gender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class genderFactoryTest {
    public void patientFactoryTest(){
        Gender gender = new Gender.genderBuilder().setGenderID(Helper.generateID())
                                                      .setName(Helper.generateID())
                                                      .setDescription(Helper.generateID())
                                                      .setSex(Helper.generateID())
                                                      .Builder();
        assertNotNull(gender);
    }

    public void AppointmentFactoryTest(){

        Gender gender = GenderFactory.createGender(Helper.generateID(), Helper.generateID(), Helper.generateID(), Helper.generateID());
        assertNotNull(gender);
    }
}