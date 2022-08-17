package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.domain.Gender;
import za.ac.cput.factory.GenderFactory;
import za.ac.cput.repository.impl.genderRepositoryImpl;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class genderRepositoryImplTest {
    private static genderRepositoryImpl repository = genderRepositoryImpl.getRepository();
    private static Gender gender = GenderFactory.createGender(Helper.generateID(), Helper.generateID(), Helper.generateID(), Helper.generateID());

    @Test
    void a_create() {
        Gender created = repository.create(gender);
        assertEquals(gender.getGenderID(), created.getGenderID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Gender read = repository.read(gender.getGenderID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        Gender update = new Gender.genderBuilder()
                .copy(gender)
                .setGenderID(Helper.generateID())
                .Builder();
        Gender updatedApp = repository.update(update);
        assertNotNull(updatedApp);
        System.out.println("Updated: " + updatedApp.getGenderID());

    }

    @Test
    void e_delete() {
        boolean success = repository.delete(gender.getGenderID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

}