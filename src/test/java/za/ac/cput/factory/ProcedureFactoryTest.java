/*
 * ProcedureFactoryTest.java
 * Factory test for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 10 April 2022
 * */
package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Procedure;

import static org.junit.jupiter.api.Assertions.*;

class ProcedureFactoryTest {

    @Test
    void createProcedure() {
        Procedure procedure = ProcedureFactory.createProcedure("1002006", "X-Ray", "Chest x-ray", "R2500.00");
        assertNotNull(procedure);
        System.out.println(procedure);
    }
}