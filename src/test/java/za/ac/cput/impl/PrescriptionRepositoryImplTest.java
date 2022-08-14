/*
 * PrescriptionRepositoryImplTest.java
 * Repository test for the Prescription
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Prescription;
import za.ac.cput.factory.PrescriptionFactory;
import za.ac.cput.repository.impl.PrescriptionRepositoryImpl;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PrescriptionRepositoryImplTest {
    private static PrescriptionRepositoryImpl repository = PrescriptionRepositoryImpl.getRepository();
    private static Prescription prescription = PrescriptionFactory.createPrescription("1001008", "1002002", "6-April-2022", "Every 5 months");

    @Test
    void a_create() {
        Prescription created = repository.create(prescription);
        assertEquals(prescription.getScriptRef(), created.getScriptRef());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Prescription read = repository.read(prescription.getScriptRef());
        assertNotNull(read);
        assertEquals(prescription.getScriptRef(), read.getScriptRef());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Prescription updated = new Prescription.Builder().copy(prescription).setScriptRecurrence("Every 2 months").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(prescription.getScriptRef());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show all: ");
        System.out.println(repository.getAll());
    }
}