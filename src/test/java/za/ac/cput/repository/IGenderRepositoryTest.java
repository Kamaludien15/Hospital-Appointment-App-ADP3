/**
 * Rhegan Albert Fortuin
 * 219273693
 * GenderRepositoryTest
 * 16 August 2022
 */

package za.ac.cput.repository;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Appointment;
import za.ac.cput.domain.Gender;
import za.ac.cput.factory.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class IGenderRepositoryTest {

    @Autowired private IGenderRepository genderRepository;
    private Gender gender;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
    }

    @AfterEach
    void tearDown(){
        this.genderRepository.delete(this.gender);
    }

    @Test
    void save() {
        Gender saved = this.genderRepository.save(this.gender);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.gender, saved);
    }

    @Test
    void read() {
        Gender saved = this.genderRepository.save(this.gender);
        Optional<Gender> read = this.genderRepository.findById(this.gender.getGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Gender saved = this.genderRepository.save(this.gender);
        this.genderRepository.delete(saved);
        List<Gender> genderListSet = this.genderRepository.findAll();
        assertEquals(0,genderListSet.size());
    }

    @Test
    void getAll() {
        this.genderRepository.save(this.gender);
        List<Gender> genderList = this.genderRepository.findAll();
        assertEquals(1,genderList.size());
    }
}