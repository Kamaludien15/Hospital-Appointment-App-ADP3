package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */


import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.*;

public class PatientGenderFactory {
    public static PatientGender createPatientGender(Patient patientID, Gender genderID){
        //Check for empty or null
        if(Helper.isEmptyOrNull(patientID.toString()) || Helper.isEmptyOrNull(genderID.toString()))
            return null;

        //Generating patientGenderID
        String patientIDGen = Helper.generateID();

        return new PatientGender.patientGenderBuilder().setPatientGenderID(patientIDGen)
                                                       .setPatientID(patientID)
                                                       .setGenderID(genderID)
                                                       .build();
    }
}
