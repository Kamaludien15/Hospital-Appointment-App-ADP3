/*
 * PrescriptionFactory.java
 * Factory for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import za.ac.cput.entity.Prescription;

public class PrescriptionFactory {
    public static Prescription createPrescription(String scriptRef, String medicineID, String scriptIssueDate, String scriptRecurrence) {
        return new Prescription.Builder().setScriptRef(scriptRef).setMedicineID(medicineID).setScriptIssueDate(scriptIssueDate).setScriptRecurrence(scriptRecurrence).build();
    }
}
