package za.ac.cput.factory;
/*
 ContactTypeFactoryTest.java
 test class for ContactTypeFactory
 Author: Kamaludien Sonday (218168128)
 Date: 10 April 2022
 */
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.domain.ContactType;

import static org.junit.jupiter.api.Assertions.*;

class ContactTypeFactoryTest {
    private ContactType contact1;
    private ContactType contact2;
    private ContactType contact3;

    @BeforeEach
    void setUp() {
        contact1 = ContactTypeFactory.createContactType("John", true, "Doctor");
        contact2 = ContactTypeFactory.createContactType("Mark", false, "Patient");
        contact3 = contact1;
    }

    @Test
    void testEquality() {
        assertSame(contact1, contact3);
        assertNotSame(contact1, contact2);
    }

    @Test
    void testIdentity() {
        assertSame(contact1, contact2);
    }

    @Test
    void testNull() {
        assertNotNull(contact1);
    }
}