/*
 * MedicineFactory.java
 * Factory for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import za.ac.cput.entity.Medicine;

public class MedicineFactory {
    public static Medicine createMedicine(String medicineID, String volume, String dosage, String price) {
        return new Medicine.Builder().setMedicineID(medicineID).setVolume(volume).setDosage(dosage).setPrice(price).build();
    }
}
