package za.ac.cput.api;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ContactType;
import za.ac.cput.domain.Hospital;
import za.ac.cput.factory.ContactTypeFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactTypeAPITest {

    @Autowired private ContactTypeAPI api;

    private ContactType contactType;

    @BeforeEach
    void setUp() {
        this.contactType = ContactTypeFactory.createContactType("Luke", true, "I am a jedi");
    }

    @AfterEach
    void tearDown(){
        this.api.delete(this.contactType);
    }

    @Test
    void save() {
        ContactType saved = this.api.save(this.contactType);
        assertNotNull(saved);
        assertSame(this.contactType.getContactTypeId(), saved.getContactTypeId());
    }

    @Test
    void read() {
        Optional<ContactType> saved = this.api.read(this.contactType.getContactTypeId());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.contactType);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        ContactType saved = this.api.save(this.contactType);
        assertEquals(1, this.api.getAll().size());
    }
}