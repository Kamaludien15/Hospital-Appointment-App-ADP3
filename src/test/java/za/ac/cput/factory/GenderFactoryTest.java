package za.ac.cput.factory;


import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Gender;
import za.ac.cput.util.*;
import static org.junit.jupiter.api.Assertions.*;


class GenderFactoryTest {

    @Test
    public void patientFactoryTest(){
        Gender gender = new Gender.genderBuilder().setGenderID(Helper.generateID())
                                                      .setName("Rhegan")
                                                      .setDescription("Born a male on the 19th of August in the year 2000")
                                                      .setSex("Male")
                                                      .build();
        assertNotNull(gender);
        System.out.println(gender);
    }
}