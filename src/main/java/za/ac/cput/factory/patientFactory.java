package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * PatientFactory
 * 15 August 2022
 *
 */

import za.ac.cput.domain.Patient;
import za.ac.cput.util.Helper;

public class PatientFactory {
    public static Patient createPatient(String patientFirstName, String patientLastName, String patientDateOfBirth){

        //Check for empty or null
        if(Helper.checkingEntity(patientFirstName) || Helper.checkingEntity(patientLastName) || Helper.checkingEntity(patientDateOfBirth))
            return null;

        //Generating patientID
        String patientID = Helper.generateID();

        return new Patient.patientBuilder().setPatientID(patientID)
                                           .setPatientFirstName(patientFirstName)
                                           .setPatientLastName(patientLastName)
                                           .setPatientDateOfBirth(patientDateOfBirth)
                                           .build();
    }
}
