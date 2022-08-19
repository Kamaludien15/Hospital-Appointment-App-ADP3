/**
 * Rhegan Albert Fortuin
 * 219273693
 * GenderFactoryTest
 * 15 August 2022
 */

package za.ac.cput.factory;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;
=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
import za.ac.cput.domain.Gender;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

<<<<<<< HEAD
class GenderFactoryTest {

    @Test
    public void patientFactoryTest(){
        Gender gender = new Gender.genderBuilder().setGenderID(Helper.generateID())
                                                      .setName("Rhegan")
                                                      .setDescription("Born a male on the 19th of August in the year 2000")
                                                      .setSex("Male")
                                                      .build();
=======
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
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe
        assertNotNull(gender);
    }
}