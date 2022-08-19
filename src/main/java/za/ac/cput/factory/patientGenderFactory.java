package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * PatientGenderFactory
 * 15 August 2022
 *
 */

import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.Helper;

public class PatientGenderFactory {
    public static PatientGender createPatientGender(Patient patientID, Gender genderID){
        //Check for empty or null
        if(Helper.checkingEntity(patientID) || Helper.checkingEntity(genderID))
            return null;

        //Generating patientGenderID
        String patientGenderID = Helper.generateID();

        return new PatientGender.patientGenderBuilder().setPatientGenderID(patientGenderID)
                                                       .setPatientID(patientID)
                                                       .setGenderID(genderID)
                                                       .build();
    }
}
