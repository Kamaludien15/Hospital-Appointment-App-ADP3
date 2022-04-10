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

public class patientFactory {
    public static patient createPatient(int patientID, String patientFirstName, String patientLastName, String patientDateOfBirth){
        return new patient.patientBuilder().setPatientID(patientID)
                                           .setPatientFirstName(patientFirstName)
                                           .setPatientLastName(patientLastName)
                                           .setPatientDateOfBirth(patientDateOfBirth)
                                           .Builder();
    }
}
