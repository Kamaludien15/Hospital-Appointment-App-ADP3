/*
 * MedicineRepositoryImplTest.java
 * Repository test for the Medicine
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Medicine;
import za.ac.cput.factory.MedicineFactory;
import za.ac.cput.repository.impl.MedicineRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class MedicineRepositoryImplTest {
    private static MedicineRepositoryImpl repository = MedicineRepositoryImpl.getRepository();
    private static Medicine medicine = MedicineFactory.createMedicine("1001002", "100ml", "5ml", "R150.00");

    @Test
    void a_create() {
        Medicine created = repository.create(medicine);
        assertEquals(medicine.getMedicineID(), created.getMedicineID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Medicine read = repository.read(medicine.getMedicineID());
        assertNotNull(read);
        assertEquals(medicine.getMedicineID(), read.getMedicineID());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Medicine updated = new Medicine.Builder().copy(medicine).setDosage("10ml").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(medicine.getMedicineID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}