package za.ac.cput.api;

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
class GenderAPITest {
    @Autowired private GenderAPI genderAPI;
    private Gender gender;

    @BeforeEach
    void setUp() {
        this.gender = GenderFactory.createGender("Rhegan", "Born a male on the 19th of August in the year 2000", "Male");
    }

    @AfterEach
    void tearDown(){
        this.genderAPI.delete(this.gender);
    }

    @Test
    void save() {
        Gender savedGender = this.genderAPI.save(this.gender);
        assertNotNull(savedGender);

        assertSame(this.gender.getGenderID(), savedGender.getGenderID());
    }

    @Test
    void read() {
        Gender savedGender = this.genderAPI.save(this.gender);

        Optional<Gender> read = this.genderAPI.read(this.gender.getGenderID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(savedGender.getGenderID(), read.get().getGenderID())
        );
    }

    @Test
    void delete() {
        Gender savedGender = this.genderAPI.save(this.gender);

        this.genderAPI.delete(savedGender);
        List<Gender> genderListSet = this.genderAPI.getAll();
        assertEquals(0,genderListSet.size());
    }

    @Test
    void getAll() {
        Gender savedGender = this.genderAPI.save(this.gender);

        List<Gender> genderList = this.genderAPI.getAll();
        assertEquals(1,genderList.size());
    }
}