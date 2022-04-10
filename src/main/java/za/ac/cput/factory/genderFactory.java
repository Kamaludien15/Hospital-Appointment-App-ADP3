package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.gender;

public class genderFactory {
    public static gender createGender(int genderID, String name, String description, String sex){
        return new gender.genderBuilder().setGenderID(genderID)
                                         .setName(name)
                                         .setDescription(description)
                                         .setSex(sex)
                                         .Builder();
    }
}
