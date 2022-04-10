package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.patientGender;
import za.ac.cput.factory.patientGenderFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class patientGenderRepositoryImplTest {
    private static patientGenderRepositoryImpl repository = patientGenderRepositoryImpl.getRepository();
    private static patientGender patientGender = patientGenderFactory.createPatientGender(Helper.generateID(), Helper.generateID());

    @Test
    void a_create() {
        patientGender created = repository.create(patientGender);
        assertEquals(patientGender.getPatientID(), created.getPatientID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        patientGender read = repository.read(patientGender.getPatientID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        patientGender update = new patientGender.patientGenderBuilder()
                .copy(patientGender)
                .setPatientID(Helper.generateID())
                .Builder();
        patientGender updatedApp = repository.update(update);
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