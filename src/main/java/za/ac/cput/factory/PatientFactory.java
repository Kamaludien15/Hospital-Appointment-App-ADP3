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
<<<<<<< HEAD:src/main/java/za/ac/cput/factory/patientFactory.java
    public static Patient createPatient(String patientFirstName, String patientLastName, String patientDateOfBirth){
=======
    public static Patient createPatient(String patientID, String patientFirstName, String patientLastName, String patientDateOfBirth){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe:src/main/java/za/ac/cput/factory/PatientFactory.java

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
