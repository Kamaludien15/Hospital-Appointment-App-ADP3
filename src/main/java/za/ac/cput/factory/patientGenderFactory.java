package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.patientGender;

public class patientGenderFactory {
    public static patientGender createPatientGender(int patientID, int genderID){
        return new patientGender.patientGenderBuilder().setPatientID(patientID)
                                                       .setGenderID(genderID)
                                                       .Builder();
    }
}
