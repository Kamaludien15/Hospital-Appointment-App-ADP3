package za.ac.cput.impl;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.gender;
import za.ac.cput.factory.genderFactory;
import za.ac.cput.util.Helper;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class genderRepositoryImplTest {
    private static genderRepositoryImpl repository = genderRepositoryImpl.getRepository();
    private static gender gender = genderFactory.createGender(Helper.generateID(), Helper.generateID(), Helper.generateID(), Helper.generateID());

    @Test
    void a_create() {
        gender created = repository.create(gender);
        assertEquals(gender.getGenderID(), created.getGenderID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        gender read = repository.read(gender.getGenderID());
        assertNotNull(read);
        System.out.println("Read:" + read);
    }

    @Test
    void c_update() {
        gender update = new gender.genderBuilder()
                .copy(gender)
                .setGenderID(Helper.generateID())
                .Builder();
        gender updatedApp = repository.update(update);
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