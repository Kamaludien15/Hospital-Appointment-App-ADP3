/* AddressServicesImplTest.java
 Test class for AddressServices
 Author: Dominic Dave Przygonski (219206414)
 Date: 14 June 2022
*/
package za.ac.cput.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.domain.*;
import za.ac.cput.factory.*;
import za.ac.cput.service.HospitalService;

import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HospitalServiceTest {

    private Hospital hospital;

    @Autowired private HospitalService service;

    @BeforeEach
    void setUp() {
        this.hospital = HospitalFactory.createHospital("Spring View Hospital", 1000, "Private");
    }

    @AfterEach
    void tearDown() {
        this.service.delete(hospital);
    }

    @Test
    void save() {
        Hospital saved = this.service.save(this.hospital);
        System.out.println(saved);
        assertNotNull(saved);
        assertSame(this.hospital.getHospitalID(), saved.getHospitalID());
    }

    @Test
    void read() {
        Hospital saved = this.service.save(this.hospital);
        Optional<Hospital> read = this.service.read(hospital.getHospitalID());
        assertAll(
                ()->assertTrue(read.isPresent()),
                ()->assertSame(saved.getHospitalID(), read.get().getHospitalID())
        );
    }

    @Test
    void delete() {
        Hospital saved = this.service.save(this.hospital);
        this.service.delete(saved);
        List<Hospital> addressSet = this.service.getAll();
        assertEquals(0,addressSet.size());
    }

    @Test
    void getAll() {
        this.service.save(this.hospital);
        List<Hospital> addressSet = this.service.getAll();
        assertEquals(1,addressSet.size());
    }
}