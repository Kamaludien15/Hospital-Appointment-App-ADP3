package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * Patient entity
 * 07 April 2022
 *
 */

import za.ac.cput.domain.Patient;
import za.ac.cput.util.Helper;

public class PatientFactory {
    public static Patient createPatient(String patientID, String patientFirstName, String patientLastName, String patientDateOfBirth){

        //Check for empty or null
        if(Helper.isNullEmpty(patientID) || Helper.isNullEmpty(patientFirstName) || Helper.isNullEmpty(patientLastName) || Helper.isNullEmpty(patientDateOfBirth))
            return null;

        //Generating patientID
        String patientIDGen = Helper.generateID();

        return new Patient.patientBuilder().setPatientID(patientID)
                                           .setPatientFirstName(patientFirstName)
                                           .setPatientLastName(patientLastName)
                                           .setPatientDateOfBirth(patientDateOfBirth)
                                           .Builder();
    }
}
