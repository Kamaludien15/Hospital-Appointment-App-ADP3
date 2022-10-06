/*
 * ProcedureServiceTest.java
 * Service test for the Procedure
 * Author: Mogamad Githr Parker (220408025)
 * Date: 16 August 2022
 * */
package za.ac.cput.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Procedure;
import za.ac.cput.factory.ProcedureFactory;
import za.ac.cput.service.ProcedureService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProcedureServiceTest {
    @Autowired
    private ProcedureService procedureService;
    Procedure procedure = ProcedureFactory.createProcedure("X-Ray","Chest x-ray",
            "R2500.00");

    @Test
    void save() {
        Procedure saved = procedureService.save(procedure);
        assertNotNull(saved);
        System.out.println(saved);
    }

    @Test
    void read() {
        Procedure saved = procedureService.save(procedure);
        Optional<Procedure> read = procedureService.read(saved.getProcedureID());
        assertEquals(read.get().getProcedureID(), procedure.getProcedureID());
        System.out.println(read);
    }

    @Test
    void delete() {
        Procedure saved = procedureService.save(procedure);
        procedureService.delete(saved);
        List<Procedure> procedures = procedureService.getAll();
        assertEquals(0, procedures.size());
    }

    @Test
    void getAll() {
        procedureService.save(procedure);
        List<Procedure> procedureList = procedureService.getAll();
        assertEquals(1, procedureList.size());
    }
}