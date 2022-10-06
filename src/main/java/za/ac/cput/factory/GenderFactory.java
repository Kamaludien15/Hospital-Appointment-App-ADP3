package za.ac.cput.factory;

/**
 * * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 */

import za.ac.cput.domain.Gender;
import za.ac.cput.util.*;

public class GenderFactory {
    public static Gender createGender(String name, String description, String sex){
        //Check for empty or null
        if(Helper.isEmptyOrNull(name) || Helper.isEmptyOrNull(description) || Helper.isEmptyOrNull(sex))
            return null;

        //Generating genderID
        String genderIDGen = Helper.generateID();

        return new Gender.genderBuilder().setGenderID(genderIDGen)
                                         .setName(name)
                                         .setDescription(description)
                                         .setSex(sex)
                                         .build();
    }
}
