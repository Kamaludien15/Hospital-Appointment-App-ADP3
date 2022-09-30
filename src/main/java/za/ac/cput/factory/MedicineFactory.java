/*
 * MedicineFactory.java
 * Factory for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import za.ac.cput.domain.Medicine;
import za.ac.cput.util.Helper;

public class MedicineFactory {
    public static Medicine createMedicine(String medicineName, String volume, String dosage, String price) {
        String medicineID = Helper.generateID();

        if (Helper.isEmptyOrNull(medicineName) || Helper.isEmptyOrNull(volume) || Helper.isEmptyOrNull(dosage) ||
                Helper.isEmptyOrNull(price))
            throw new IllegalArgumentException();

        return new Medicine.Builder().setMedicineID(medicineID).setMedicineName(medicineName).
                setVolume(volume).setDosage(dosage).setPrice(price).build();
    }
}
