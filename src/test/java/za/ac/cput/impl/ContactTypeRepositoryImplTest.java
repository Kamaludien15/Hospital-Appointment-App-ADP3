package za.ac.cput.impl;
/*
 ContactTypeRepositoryImplTest.java
 test class for ContactTypeRepositoryImplTest
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.Impl.ContactTypeRepositoryImpl;
import za.ac.cput.entity.ContactType;
import za.ac.cput.factory.ContactTypeFactory;

import static org.junit.jupiter.api.Assertions.*;

class ContactTypeRepositoryImplTest {

    private ContactType contact1;
    private ContactType contact2;
    private ContactType contact3;
    private ContactTypeRepositoryImpl contactTypeRepository;

    @BeforeEach
    void setUp() {
        contact1 = ContactTypeFactory.createContactType("John", true, "Doctor");
        contact2 = ContactTypeFactory.createContactType("Mark", false, "Patient");
        contact3 = ContactTypeFactory.createContactType("Bob", true, "Doctor");
        contactTypeRepository = ContactTypeRepositoryImpl.getRepository();
        contactTypeRepository.create(contact1);
        contactTypeRepository.create(contact3);
    }

    @Test
    void testRead() {
        assertNotNull(contactTypeRepository.read(contact1.getContactTypeId()));
    }

    @Test
    void testUpdate() {
        assertNotNull(contactTypeRepository.update(contact1));
    }

    @Test
    void testDelete() {
        assertNotNull(contactTypeRepository.delete(contact1.getContactTypeId()));
    }
}