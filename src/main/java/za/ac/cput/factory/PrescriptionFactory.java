/*
 * PrescriptionFactory.java
 * Factory for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Medicine;
import za.ac.cput.domain.Prescription;
import za.ac.cput.util.Helper;

public class PrescriptionFactory {
    public static Prescription createPrescription(Medicine medicineID, String scriptIssueDate, String scriptRecurrence) {
        String scriptRef = Helper.generateID();

        if (Helper.checkingEntity(medicineID) || Helper.isEmptyOrNull(scriptIssueDate) ||
                Helper.isEmptyOrNull(scriptRecurrence))
            throw new IllegalArgumentException();

        return new Prescription.Builder().setScriptRef(scriptRef).setMedicineID(medicineID).
                setScriptIssueDate(scriptIssueDate).setScriptRecurrence(scriptRecurrence).build();
    }
}
