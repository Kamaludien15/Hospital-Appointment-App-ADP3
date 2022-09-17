package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Patient;
import za.ac.cput.factory.PatientFactory;
import za.ac.cput.repository.impl.patientRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class patientRepositoryImplTest {
    private static patientRepositoryImpl repository = patientRepositoryImpl.getRepository();
    private static Patient patient = PatientFactory.createPatient(Helper.generateID(), Helper.generateID(), Helper.generateID(),
            Helper.generateID());

    @Test
    void a_create() {
        Patient created = repository.create(patient);
        assertEquals(patient.getPatientID(), created.getPatientID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Patient read = repository.read(patient.getPatientID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Patient update = new Patient.patientBuilder()
                .copy(patient)
                .setPatientLastName("Fortuin")
                .Builder();
        Patient updatedApp = repository.update(update);
        assertNotNull(updatedApp);
        System.out.println("Updated: " + updatedApp.getPatientLastName());

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(patient.getPatientID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }
}