package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.Gender;
import za.ac.cput.factory.GenderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class IGenderRepositoryTest {
    @Autowired
    private IGenderRepository genderRepository;

    private Gender gender;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");

    }

    @AfterEach
    void tearDown() {
        this.genderRepository.delete(this.gender);
    }

    @Test
    void save() {
        Gender saved = this.genderRepository.save(this.gender);
        assertNotNull(saved);
        assertSame(this.gender.getGenderID(), saved.getGenderID());
    }


    @Test
    void read() {
        Gender saved = this.genderRepository.save(this.gender);
        Optional<Gender> read = this.genderRepository.findById(this.gender.getGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getGenderID(), read.get().getGenderID())
        );
    }

    @Test
    void delete() {
        Gender saved = this.genderRepository.save(this.gender);
        this.genderRepository.delete(saved);
        List<Gender> genderList = this.genderRepository.findAll();
        assertEquals(0,genderList.size());
    }

    @Test
    void getAll() {
        this.genderRepository.save(this.gender);
        List<Gender> genderList = this.genderRepository.findAll();
        assertEquals(1,genderList.size());
    }
}