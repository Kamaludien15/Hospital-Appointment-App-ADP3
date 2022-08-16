package za.ac.cput.factory;

import za.ac.cput.domain.*;
import za.ac.cput.util.Helper;

public class PatientContactFactory {

    public static PatientContact createPatientContact(ContactType contactType, Patient patient){
        String patientContactId = Helper.generateID();

        PatientContact patientContact = new PatientContact.Builder().setPatientContactId(patientContactId).setContactType(contactType).setPatient(patient).build();

        return patientContact;
    }

}
