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
import za.ac.cput.util.Helper;

public class genderFactory {
    public static gender createGender(String genderID, String name, String description, String sex){
        //-----Checking for empty or null variables------
        if(Helper.isNullEmpty(genderID) || Helper.isNullEmpty(name) || Helper.isNullEmpty(description) || Helper.isNullEmpty(sex))
            return null;

        //-----Generating AppointmentID-----
        String genderIDGen = Helper.generateID();

        return new gender.genderBuilder().setGenderID(genderID)
                                         .setName(name)
                                         .setDescription(description)
                                         .setSex(sex)
                                         .Builder();
    }
}
