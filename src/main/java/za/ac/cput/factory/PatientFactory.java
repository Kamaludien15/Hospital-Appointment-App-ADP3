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
import za.ac.cput.util.*;

public class PatientFactory {
    public static Patient createPatient(String patientFirstName, String patientLastName, String patientDateOfBirth, String password){

        //Check for empty or null
        if(Helper.isEmptyOrNull(patientFirstName) || Helper.isEmptyOrNull(patientLastName) || Helper.isEmptyOrNull(patientDateOfBirth) || Helper.isEmptyOrNull(password))
            return null;

        //Generating patientID
        String patientIDGen = Helper.generateID();

        return new Patient.patientBuilder().setPatientID(patientIDGen)
                                           .setPatientFirstName(patientFirstName)
                                           .setPatientLastName(patientLastName)
                                           .setPatientDateOfBirth(patientDateOfBirth)
                                           .setPassword(password)
                                           .build();
    }
}
