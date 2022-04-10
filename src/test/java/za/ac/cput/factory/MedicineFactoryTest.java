/*
 * MedicineFactoryTest.java
 * Factory test for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Medicine;

import static org.junit.jupiter.api.Assertions.*;

class MedicineFactoryTest {

    @Test
    void createMedicine() {
        Medicine medicine = MedicineFactory.createMedicine("1001002", "100ml", "5ml", "R150.00");
        assertNotNull(medicine);
        System.out.println(medicine);
    }
}