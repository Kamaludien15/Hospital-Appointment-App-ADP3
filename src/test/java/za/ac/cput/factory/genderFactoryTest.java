package za.ac.cput.factory;

import za.ac.cput.entity.gender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

class genderFactoryTest {
    public void patientFactoryTest(){
        gender gender = new gender.genderBuilder().setGenderID(Helper.generateID())
                                                      .setName(Helper.generateID())
                                                      .setDescription(Helper.generateID())
                                                      .setSex(Helper.generateID())
                                                      .Builder();
        assertNotNull(gender);
    }

    public void AppointmentFactoryTest(){

        gender gender = genderFactory.createGender(Helper.generateID(), Helper.generateID(), Helper.generateID(), Helper.generateID());
        assertNotNull(gender);
    }
}