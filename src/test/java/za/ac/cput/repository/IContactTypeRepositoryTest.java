package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.ContactType;
import za.ac.cput.factory.ContactTypeFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IContactTypeRepositoryTest {
    
    @Autowired private IContactTypeRepository contactTypeRepository;
    
    private ContactType contactType;

    @BeforeEach
    void setUp() {
        this.contactType = ContactTypeFactory.createContactType("John", false, "Not very sick");
    }

    @AfterEach
    void tearDown() {
        this.contactTypeRepository.delete(this.contactType);
    }

    @Test
    void save() {
        ContactType saved = this.contactTypeRepository.save(this.contactType);
        assertNotNull(saved);
        assertSame(this.contactType, saved);
    }


    @Test
    void read() {
        ContactType saved = this.contactTypeRepository.save(this.contactType);
        Optional<ContactType> read = this.contactTypeRepository.findById(this.contactType.getContactTypeId());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        ContactType saved = this.contactTypeRepository.save(this.contactType);
        this.contactTypeRepository.delete(saved);
        List<ContactType> contactTypeList = this.contactTypeRepository.findAll();
        assertEquals(0,contactTypeList.size());
    }

    @Test
    void getAll() {
        this.contactTypeRepository.save(this.contactType);
        List<ContactType> contactTypeList = this.contactTypeRepository.findAll();
        assertEquals(1,contactTypeList.size());
    }
}