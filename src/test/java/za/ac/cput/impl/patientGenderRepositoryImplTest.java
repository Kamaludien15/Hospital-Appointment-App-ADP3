package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.PatientGender;
import za.ac.cput.factory.PatientGenderFactory;
import za.ac.cput.repository.*;
import za.ac.cput.util.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class patientGenderRepositoryImplTest {
    private static patientGenderRepository repository = patientGenderRepository.getRepository();
    private static PatientGender patientGender = PatientGenderFactory.createPatientGender(Helper.generateID(), Helper.generateID());

    @Test
    void a_create() {
        PatientGender created = repository.create(patientGender);
        assertEquals(patientGender.getPatientID(), created.getPatientID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        PatientGender read = repository.read(patientGender.getPatientID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        PatientGender update = new PatientGender.patientGenderBuilder()
                .copy(patientGender)
                .setPatientID(Helper.generateID())
                .Builder();
        PatientGender updatedApp = repository.update(update);
        assertNotNull(updatedApp);
        System.out.println("Updated: " + updatedApp.getPatientID());

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(patientGender.getPatientID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

}