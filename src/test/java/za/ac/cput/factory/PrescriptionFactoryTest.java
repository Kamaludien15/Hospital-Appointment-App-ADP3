/*
 * PrescriptionFactoryTest.java
 * Factory test for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Medicine;
import za.ac.cput.domain.Prescription;

import static org.junit.jupiter.api.Assertions.*;

class PrescriptionFactoryTest {

    @Test
    void createPrescription() {
        Medicine medicine = MedicineFactory.createMedicine("Ibuprofen", "100ml", "5ml",
                "R150.00");
        Prescription prescription = PrescriptionFactory.createPrescription(medicine, "10/08/2022",
                "monthly");
        assertNotNull(prescription);
        System.out.println(prescription);
    }
}