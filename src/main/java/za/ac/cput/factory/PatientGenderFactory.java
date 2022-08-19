package za.ac.cput.factory;

/**
 *
 * Rhegan Albert Fortuin
 * 219273693
 * PatientGenderFactory
 * 15 August 2022
 *
 */

<<<<<<< HEAD:src/main/java/za/ac/cput/factory/patientGenderFactory.java
import za.ac.cput.domain.Gender;
import za.ac.cput.domain.Patient;
=======
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe:src/main/java/za/ac/cput/factory/PatientGenderFactory.java
import za.ac.cput.domain.PatientGender;
import za.ac.cput.util.Helper;

public class PatientGenderFactory {
<<<<<<< HEAD:src/main/java/za/ac/cput/factory/patientGenderFactory.java
    public static PatientGender createPatientGender(Patient patientID, Gender genderID){
=======
    public static PatientGender createPatientGender(String patientID, String genderID){
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe:src/main/java/za/ac/cput/factory/PatientGenderFactory.java
        //Check for empty or null
        if(Helper.checkingEntity(patientID) || Helper.checkingEntity(genderID))
            return null;

        //Generating patientGenderID
        String patientGenderID = Helper.generateID();

<<<<<<< HEAD:src/main/java/za/ac/cput/factory/patientGenderFactory.java
        return new PatientGender.patientGenderBuilder().setPatientGenderID(patientGenderID)
                                                       .setPatientID(patientID)
=======
        return new PatientGender.patientGenderBuilder().setPatientID(patientID)
>>>>>>> 0841c97978f4d9d8b54b66f900a2c5ba1a055ebe:src/main/java/za/ac/cput/factory/PatientGenderFactory.java
                                                       .setGenderID(genderID)
                                                       .build();
    }
}
