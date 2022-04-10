/*
 * ProcedureRepositoryImplTest.java
 * Repository test for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Procedure;
import za.ac.cput.factory.ProcedureFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ProcedureRepositoryImplTest {
    private static ProcedureRepositoryImpl repository = ProcedureRepositoryImpl.getRepository();
    private static Procedure procedure = ProcedureFactory.createProcedure("1001002", "X-Ray", "Chest x-ray", "R4500.00");

    @Test
    void a_create() {
        Procedure created = repository.create(procedure);
        assertEquals(procedure.getProcedureID(), created.getProcedureID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Procedure read = repository.read(procedure.getProcedureID());
        assertNotNull(read);
        assertEquals(procedure.getProcedureID(), read.getProcedureID());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Procedure updated = new Procedure.Builder().copy(procedure).setProcedureCost("R2300.00").build();
        assertNotNull(repository.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void d_delete() {
        boolean success = repository.delete(procedure.getProcedureID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }
}