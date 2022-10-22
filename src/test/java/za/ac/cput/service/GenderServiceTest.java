/**
 * GenderServiceTest.java
 * Test Class for GenderServices
 * Rhegan Albert Fortuin
 * 2022/10/13
 */
package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GenderServiceTest {
    private Gender genderService;

    @Autowired private GenderService service;

    @BeforeEach
    void setUp() {
        this.genderService = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(genderService);
    }

    @Test
    void save() {
        Gender saved = this.service.save(this.genderService);
        assertNotNull(saved);
        assertSame(this.genderService.getGenderID(), saved.getGenderID());
    }

    @Test
    void read() {
        Gender saved = this.service.save(this.genderService);
        Optional<Gender> read = this.service.read(this.genderService.getGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getGenderID(), read.get().getGenderID())
        );
    }

    @Test
    void delete() {
        Gender saved = this.service.save(this.genderService);
        this.service.delete(saved);
        List<Gender> genderList = this.service.getAll();
        assertEquals(0,genderList.size());
    }

    @Test
    void getAll() {
        this.service.save(this.genderService);
        List<Gender> genderList = this.service.getAll();
        assertEquals(1,genderList.size());
    }

}