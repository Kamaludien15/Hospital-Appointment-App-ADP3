/*
 * PrescriptionFactoryTest.java
 * Factory test for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.domain.Prescription;

import static org.junit.jupiter.api.Assertions.*;

class PrescriptionFactoryTest {

    @Test
    void createPrescription() {
        Prescription prescription = PrescriptionFactory.createPrescription("1002003", "1001004", "8-April-2022", "Every 3 months");
        assertNotNull(prescription);
        System.out.println(prescription);
    }
}