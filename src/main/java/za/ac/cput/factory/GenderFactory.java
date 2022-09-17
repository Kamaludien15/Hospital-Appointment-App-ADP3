package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * GenderFactory
 * 15 August 2022
 *
 */

import za.ac.cput.domain.Gender;
import za.ac.cput.util.Helper;

public class GenderFactory {
<<<<<<< HEAD:src/main/java/za/ac/cput/factory/genderFactory.java
    public static Gender createGender(String name, String description, String sex){
=======
    public static Gender createGender(String genderID, String name, String description, String sex){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe:src/main/java/za/ac/cput/factory/GenderFactory.java
        //Check for empty or null
        if(Helper.checkingEntity(name) || Helper.checkingEntity(description) || Helper.checkingEntity(sex))
            return null;

        //Generating genderID
        String genderID = Helper.generateID();

        return new Gender.genderBuilder().setGenderID(genderID)
                                         .setName(name)
                                         .setDescription(description)
                                         .setSex(sex)
                                         .build();
    }
}
