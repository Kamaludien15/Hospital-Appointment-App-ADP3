/**
 * Rhegan Albert Fortuin
 * 219273693
 * GenderServiceTest
 * 16 August 2022
 */

package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import za.ac.cput.domain.Gender;
import za.ac.cput.factory.GenderFactory;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GenderServiceTest {

    @Autowired private IGenderService genderService;
    private Gender gender;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
    }

    @AfterEach
    void tearDown(){
        this.genderService.delete(this.gender);
    }

    @Test
    void save() {
        Gender saved = this.genderService.save(this.gender);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.gender, saved);
    }

    @Test
    void read() {
        Gender saved = this.genderService.save(this.gender);
        Optional<Gender> read = this.genderService.read(this.gender.getGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved, read.get())
        );
    }

    @Test
    void delete() {
        Gender saved = this.genderService.save(this.gender);
        this.genderService.delete(saved);
        List<Gender> genderListSet = this.genderService.getAll();
        assertEquals(0,genderListSet.size());
    }

    @Test
    void getAll() {
        this.genderService.save(this.gender);
        List<Gender> genderList = this.genderService.getAll();
        assertEquals(1,genderList.size());
    }
}