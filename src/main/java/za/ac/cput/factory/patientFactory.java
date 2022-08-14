package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.entity.patient;
import za.ac.cput.util.Helper;

public class patientFactory {
    public static patient createPatient(String patientID, String patientFirstName, String patientLastName, String patientDateOfBirth){

        //Check for empty or null
        if(Helper.isNullEmpty(patientID) || Helper.isNullEmpty(patientFirstName) || Helper.isNullEmpty(patientLastName) || Helper.isNullEmpty(patientDateOfBirth))
            return null;

        //Generating patientID
        String patientIDGen = Helper.generateID();

        return new patient.patientBuilder().setPatientID(patientID)
                                           .setPatientFirstName(patientFirstName)
                                           .setPatientLastName(patientLastName)
                                           .setPatientDateOfBirth(patientDateOfBirth)
                                           .Builder();
    }
}
