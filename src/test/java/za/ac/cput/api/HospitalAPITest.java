/* AddressAPITest.java
 Controller for address entity
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.IHospitalService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class HospitalAPITest {

    @Autowired private HospitalAPI api;
    private Hospital hospital;


    @BeforeEach
    void setUp() {
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    }

    @Test
    void save() {
        Hospital saved = this.api.save(this.hospital);
    }

    @Test
    void read() {
        Optional<Hospital> saved = this.api.read(this.hospital.getHospitalID());
        assertNotNull(saved);
    }

    @Test
    void delete() {
        this.api.delete(this.hospital);
        assertEquals(0, this.api.getAll().size());
    }

    @Test
    void getAll() {
        Optional<Hospital> saved = this.api.read(this.hospital.getHospitalID());
        assertEquals(1, this.api.getAll().size());
    }
}