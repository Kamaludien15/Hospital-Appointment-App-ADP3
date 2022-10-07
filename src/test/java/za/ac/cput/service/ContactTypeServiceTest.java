package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ContactType;
import za.ac.cput.factory.ContactTypeFactory;
import za.ac.cput.service.ContactTypeService;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ContactTypeServiceTest {

    private ContactType contactType;

    @Autowired private ContactTypeService service;

    @BeforeEach
    void setUp() {
        this.contactType = ContactTypeFactory.createContactType("John", true, "Doctor");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(contactType);
    }

    @Test
    void save() {
        ContactType saved = this.service.save(this.contactType);
        assertNotNull(saved);
        assertSame(this.contactType.getContactTypeId(), saved.getContactTypeId());
    }

    @Test
    void read() {
        ContactType saved = this.service.save(this.contactType);
        Optional<ContactType> read = this.service.read(this.contactType.getContactTypeId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getContactTypeId(), read.get().getContactTypeId())
        );
    }

    @Test
    void delete() {
        ContactType saved = this.service.save(this.contactType);
        this.service.delete(saved);
        List<ContactType> contactTypeList = this.service.getAll();
        assertEquals(0,contactTypeList.size());
    }

    @Test
    void getAll() {
        this.service.save(this.contactType);
        List<ContactType> contactTypeList = this.service.getAll();
        assertEquals(1,contactTypeList.size());
    }
}