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
    public static Gender createGender(String name, String description, String sex){
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
